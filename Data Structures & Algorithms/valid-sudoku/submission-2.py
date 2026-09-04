class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not self.is_row_valid(board):
            return False

        if not self.is_col_valid(board):
            return False

        if not self.is_subboxes_valid(board):
            return False

        return True

    def is_row_valid(self, board: List[List[str]]) -> bool:
        for row in board:
            values = set()
            for val in row:
                if val != "." and val in values:
                    return False
                values.add(val)

        return True

    def is_col_valid(self, board: List[List[str]]) -> bool:
        for i in range(len(board)):
            values = set()
            for j in range(len(board)):
                val = board[j][i]
                if val != "." and val in values:
                    return False
                values.add(val)

        return True

    def is_subboxes_valid(self, board: List[List[str]]) -> bool:
        box_values = defaultdict(list)
        for i in range(len(board)):
            for j in range(len(board)):
                key = (i // 3, j // 3)
                val = board[i][j]
                if val != ".":
                    box_values[key].append(val)

        for values in box_values.values():
            if len(set(values)) != len(values):
                return False

        return True
