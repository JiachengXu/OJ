package main

import (
	"fmt"
	"log"
	"strconv"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2021/4/input")
	// lines, err := utils.GetInputLines("2021/4/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	inputs := strings.Split(lines[0], ",")
	boards := [][][]string{}
	for i := 2; i < len(lines)-4; i += 6 {
		board := [][]string{}
		for j := 0; j < 5; j++ {
			board = append(board, strings.Fields(lines[i+j]))
		}
		boards = append(boards, board)
	}

	for i := 0; i < len(boards); i++ {
		for j := 0; j < len(boards[0]); j++ {
			fmt.Println(boards[i][j])
		}
		fmt.Println("")
	}

	win := -1
	lin := ""
	for _, in := range inputs {
		for i := 0; i < len(boards); i++ {
			for j := 0; j < len(boards[0]); j++ {
				for k := 0; k < len(boards[0][0]); k++ {
					if in == boards[i][j][k] {
						boards[i][j][k] = ""
					}
				}
			}
		}
		for i := 0; i < len(boards); i++ {
			b := boards[i]
			for j := 0; j < len(b); j++ {
				if strings.Join(b[j], "") == "" {
					win = i
					lin = in
					goto win
				}
			}
			for j := 0; j < len(b[0]); j++ {
				if strings.Join(b[:][j], "") == "" {
					win = i
					lin = in
					goto win
				}
			}
		}
	}

win:
	res := 0
	winb := boards[win]
	for i := 0; i < len(winb); i++ {
		fmt.Println(winb[i])
	}

	linn, err := strconv.Atoi(lin)
	if err != nil {
		log.Fatal(err)
	}
	for i := 0; i < len(winb); i++ {
		for j := 0; j < len(winb[0]); j++ {
			if winb[i][j] != "" {
				n, err := strconv.Atoi(winb[i][j])
				if err != nil {
					log.Fatal(err)
				}
				fmt.Println(n)
				res += n
			}
		}
	}
	fmt.Println(res * linn)
}

func solve2(lines []string) {
	inputs := strings.Split(lines[0], ",")
	boards := [][][]string{}
	for i := 2; i < len(lines)-4; i += 6 {
		board := [][]string{}
		for j := 0; j < 5; j++ {
			board = append(board, strings.Fields(lines[i+j]))
		}
		boards = append(boards, board)
	}

	for i := 0; i < len(boards); i++ {
		for j := 0; j < len(boards[0]); j++ {
			fmt.Println(boards[i][j])
		}
		fmt.Println("")
	}

	m := map[int]bool{}
	win := -1
	lin := ""
	for _, in := range inputs {
		for i := 0; i < len(boards); i++ {
			for j := 0; j < len(boards[0]); j++ {
				for k := 0; k < len(boards[0][0]); k++ {
					if in == boards[i][j][k] {
						boards[i][j][k] = ""
					}
				}
			}
		}
	checkwin:
		for i := 0; i < len(boards); i++ {
			if m[i] {
				continue
			}
			b := boards[i]
			for j := 0; j < len(b); j++ {
				if strings.Join(b[j], "") == "" {
					m[i] = true
					if len(m) == len(boards) {
						win = i
						lin = in
						goto win
					}
					goto checkwin
				}
			}
			for j := 0; j < len(b[0]); j++ {
				if strings.Join(b[:][j], "") == "" {
					m[i] = true
					if len(m) == len(boards) {
						win = i
						lin = in
						goto win
					}
					goto checkwin
				}
			}
		}
	}

win:
	res := 0
	winb := boards[win]
	for i := 0; i < len(winb); i++ {
		fmt.Println(winb[i])
	}

	linn, err := strconv.Atoi(lin)
	if err != nil {
		log.Fatal(err)
	}
	for i := 0; i < len(winb); i++ {
		for j := 0; j < len(winb[0]); j++ {
			if winb[i][j] != "" {
				n, err := strconv.Atoi(winb[i][j])
				if err != nil {
					log.Fatal(err)
				}
				fmt.Println(n)
				res += n
			}
		}
	}
	fmt.Println(res * linn)
}
