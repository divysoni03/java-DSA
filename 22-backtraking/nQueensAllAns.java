public class nQueensAllAns {
    public static void nQueens(char board[][], int row) {
        // base case
        if(row == board.length) {
            printBoard(board); // if we hit base case print the board (means all queens are placed)
            return;
        }

        for(int j=0;j<board.length;j++) {
            if(isSafeToPlace(board, row, j)) {
                board[row][j] = 'Q'; // if safe to place then place
                nQueens(board, row+1); // after placing the queen go to the next row to place the next queen
                // if no possible solution ahead and we backtrack then we have to remove the placed queen
                board[row][j] = 'x';
            }
        }
    }
    public static boolean isSafeToPlace(char board[][], int row, int col) {
        // vertically up (i--, j)
        for(int i=row-1;i>=0;i--) {
            if(board[i][col] == 'Q') return false;
        }

        // left diagonally (i--, j--)
        for(int i=row-1, j=col-1;i>=0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q') return false;
        }

        // right diagonally (i--, j++)
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++) {
            if(board[i][j] == 'Q') return false;
        }

        // else
        return true;
    }

    public static void printBoard(char board[][]) {
        System.out.println("------- chess board -------");
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                board[i][j] = 'x';
            }
        }
        nQueens(board, 0);
    }
}
