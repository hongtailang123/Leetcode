class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # check rows
        return self.isRowValid(board) and self.isColumnValid(board) and self.isSquareValid(board)
    
    def isRowValid(self, board):
        for row in board:
            if not self.isUnitValid(row):
                return False
        return True
        
    def isColumnValid(self, board):
        for col in zip(*board):
            if not self.isUnitValid(col):
                return False
        return True
        
    def isSquareValid(self, board):
        for i in (0, 3, 6):
            for j in (0, 3, 6):
                square = [board[x][y] for x in range(i, i + 3) for y in range(j, j + 3)]
                if not self.isUnitValid(square):
                    return False
        return True
    
    def isUnitValid(self, unit):
        res = [i for i in unit if i != '.']
        return len(res) == len(set(res))
