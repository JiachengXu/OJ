package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

var (
	folders = map[string]int{}
)

func main() {
	lines, err := utils.GetInputLines("2022/7/input")
	// lines, err := utils.GetInputLines("2022/7/small")
	if err != nil {
		log.Fatal(err)
	}
	buildDirs(lines)
	solve1()
	solve2()
}

func solve1() {
	res := 0
	for _, v := range folders {
		if v < 100000 {
			res += v
		}
	}
	fmt.Println(res)
}

func solve2() {
	min := 70000000
	for _, v := range folders {
		if 70000000-folders["/"]+v > 30000000 && v < min {
			min = v
		}
	}
	fmt.Println(min)
}

func buildDirs(lines []string) {
	curs := []string{}
	for _, s := range lines {
		parts := strings.Split(s, " ")
		if strings.HasPrefix(s, "$ cd") {
			dir := parts[len(parts)-1]
			if dir == ".." {
				curs = curs[:len(curs)-1]
			} else {
				curs = append(curs, dir)
			}
			folderName := strings.Join(curs, "/")
			if _, ok := folders[folderName]; !ok {
				folders[folderName] = 0
			}
			continue
		}
		if strings.HasPrefix(s, "$ ls") || strings.HasPrefix(s, "dir") {
			continue
		}
		size := utils.Int(parts[0])
		name := append(curs, parts[1])
		fileName := strings.Join(name, "/")
		for folderName := range folders {
			if strings.HasPrefix(fileName, folderName) {
				folders[folderName] += int(size)
			}
		}
	}
}
