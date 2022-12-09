package main

import (
	"bytes"
	"errors"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"os"
	"os/exec"
	"path/filepath"
	"strconv"
	"strings"
	"time"

	"github.com/spf13/cobra"
)

type flags struct {
	year, day, part int
	cookie          string
}

func main() {
	f := flags{}
	defaultYear := time.Now().Year()
	yearEnv := os.Getenv("AOC_YEAR")
	if yearEnv != "" {
		y, err := strconv.Atoi(yearEnv)
		if err != nil {
			log.Fatal(err)
		}
		defaultYear = y
	}
	defaultDay := 1
	dayEnv := os.Getenv("AOC_DAY")
	if dayEnv != "" {
		d, err := strconv.Atoi(dayEnv)
		if err != nil {
			log.Fatal(err)
		}
		defaultDay = d
	}
	rootCommand := &cobra.Command{
		Use:   "aoc",
		Short: "A CLI tool for the Advent of Code",
	}
	rootCommand.PersistentFlags().IntVarP(&f.year, "year", "y", defaultYear, "the year")
	rootCommand.PersistentFlags().IntVarP(&f.day, "day", "d", defaultDay, "the day")
	rootCommand.PersistentFlags().StringVarP(&f.cookie, "cookie", "c", os.Getenv("AOC_COOKIE"), "the cookie that is used to get input and submit result.")

	if f.cookie == "" {
		log.Fatal("Don't forget to set cookie!")
	}

	init := &cobra.Command{
		Use:   "init",
		Short: "Init the puzzle",
		RunE: func(cmd *cobra.Command, args []string) error {
			if err := getTestInput(f); err != nil {
				return err
			}
			return generateGoCode(f)
		},
	}
	rootCommand.AddCommand(init)

	run := &cobra.Command{
		Use:   "run",
		Short: "Run the puzzle",
		RunE: func(cmd *cobra.Command, args []string) error {
			if err := getTestInput(f); err != nil {
				return err
			}
			_, err := runCode(f)
			return err
		},
	}
	rootCommand.AddCommand(run)

	submit := &cobra.Command{
		Use:   "sub",
		Short: "Submit the solution",
		RunE: func(cmd *cobra.Command, args []string) error {
			if err := getTestInput(f); err != nil {
				return err
			}
			ans, err := runCode(f)
			if err != nil {
				return err
			}
			return submit(f, ans)
		},
	}
	submit.Flags().IntVarP(&f.part, "part", "p", 1, "the part")
	rootCommand.AddCommand(submit)
	if err := rootCommand.Execute(); err != nil {
		log.Fatal(err)
	}
}

func getTestInput(f flags) error {
	fileName := fmt.Sprintf("%d/%d/input", f.year, f.day)
	smallfileName := fmt.Sprintf("%d/%d/small", f.year, f.day)
	_, err := os.Stat(fileName)
	if err == nil {
		return nil
	} else if err != nil && !errors.Is(err, os.ErrNotExist) {
		return err
	}
	client := http.Client{}
	url := fmt.Sprintf("https://adventofcode.com/%d/day/%d/input", f.year, f.day)
	req, err := http.NewRequest(http.MethodGet, url, nil)
	if err != nil {
		return err
	}
	req.Header.Add("cookie", f.cookie)
	resp, err := client.Do(req)
	defer resp.Body.Close()
	if err := os.MkdirAll(filepath.Dir(fileName), os.ModePerm); err != nil {
		return err
	}
	_, err = os.Create(smallfileName)
	if err != nil {
		return err
	}
	file, err := os.Create(fileName)
	if err != nil {
		return err
	}
	defer file.Close()
	if _, err := file.ReadFrom(resp.Body); err != nil {
		return err
	}
	return nil
}

func generateGoCode(f flags) error {
	fileName := fmt.Sprintf("%d/%d/main.go", f.year, f.day)
	_, err := os.Stat(fileName)
	if err == nil {
		return nil
	} else if err != nil && !errors.Is(err, os.ErrNotExist) {
		return err
	}
	if err := os.MkdirAll(filepath.Dir(fileName), os.ModePerm); err != nil {
		return err
	}
	file, err := os.Create(fileName)
	if err != nil {
		return err
	}
	defer file.Close()
	goTemp := fmt.Sprintf(`package main

import (
	"fmt"
	"log"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("%d/%d/input")
	// lines, err := utils.GetInputLines("%d/%d/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	for _, line := range lines {
		fmt.Println(line)
	}
}

func solve2(lines []string) {
}
`, f.year, f.day, f.year, f.day)

	_, err = file.WriteString(goTemp)
	return err
}

func runCode(f flags) (string, error) {
	fileName := fmt.Sprintf("%d/%d/main.go", f.year, f.day)
	cmd := exec.Command("go", "run", fileName)
	out, err := cmd.CombinedOutput()
	fmt.Println(strings.TrimSpace(string(out)))
	if err != nil {
		return "", err
	}
	outs := strings.Split(strings.TrimSpace(string(out)), "\n")
	answer := outs[len(outs)-1]
	fmt.Printf("answer: %s\n", answer)
	return answer, nil
}

func submit(f flags, answer string) error {
	client := http.Client{}
	url := fmt.Sprintf("https://adventofcode.com/%d/day/%d/answer", f.year, f.day)
	req, err := http.NewRequest(http.MethodPost, url, bytes.NewBufferString(fmt.Sprintf("level=%d&answer=%s", f.part, answer)))
	if err != nil {
		return err
	}
	req.Header.Add("cookie", f.cookie)
	req.Header.Add("Content-Type", "application/x-www-form-urlencoded")
	resp, err := client.Do(req)
	defer resp.Body.Close()
	b, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		return err
	}

	fmt.Println(strings.Split(strings.Split(string(b), "<article><p>")[1], "</p></article>")[0])
	return nil
}
