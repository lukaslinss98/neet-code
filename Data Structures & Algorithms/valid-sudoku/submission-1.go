func isValidSudoku(board [][]byte) bool {

	if !checkRows(board) {
		fmt.Println("rows false")
		return false
	}

	if !checkCols(board) {
		fmt.Println("cols false")
		return false
	}

	if !checkBoxes(board) {
		fmt.Println("boxes false")
		return false
	}

	return true
}

func checkBoxes(board [][]byte) bool {
	for i := range 3 {
		for k := range 3 {

			row := i * 3
			col := k * 3

			set := make(map[byte]struct{})
			for r := row; r < row+3; r++ {
				for j := col; j < col+3; j++ {
					cell := board[r][j]
					if cell == '.' {
						continue
					}
					if _, ok := set[cell]; ok {
						return false
					}
					set[cell] = struct{}{}
				}
			}
		}
	}
	return true
}


func checkRows(board [][]byte) bool {
	for _, row := range board {
		set := make(map[byte]struct{})
        for _, cell := range row {
			if cell == '.' {
				continue
			}
			if _, ok := set[cell]; ok {
				return false
			}
			set[cell] = struct{}{}
        }
	}
	return true
}

func checkCols(board [][]byte) bool {
	for j := 0; j < len(board[0]); j++ {
		set := make(map[byte]struct{})
		for i := range board {
			cell := board[i][j]
			if cell == '.' {
				continue
			}
			if _, ok := set[cell]; ok {
				return false
			}
			set[cell] = struct{}{}
		}
	}
	return true
}
