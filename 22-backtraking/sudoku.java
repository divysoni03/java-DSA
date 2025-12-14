public class sudoku {
    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        // base case
        if(row == 9 && col == 0) return true;


        // calculating next row and next col -> next cell { (0, 0) -> (0, 1) which is next cell }
        int nextRow = row; // same row 
        int nextCol = col+1; // next col
        
        if(nextCol == 9) { // if col had reached end then move to the next row start again
            nextRow = row+1;
            nextCol = 0;
        }

        // not touching the pre placed digits in the sudoku
        if(sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol); // calling for next cell (not changing the curr pre placed cell)
        }

        // main work (recursion)
        for(int digit=1; digit<=9 ; digit++) {
            if(isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit; // if safe then place the curr digit
                if(sudokuSolver(sudoku, nextRow, nextCol)) return true; // move to next cell
            }
            sudoku[row][col] = 0; // if backtracked then remove the placed digit
        }

        return false;
    }
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // check in column
        for(int i=0;i<sudoku.length; i++) {
            if(sudoku[i][col] == digit) return false;
        }

        // check in row
        for(int i=0;i<sudoku.length;i++) {
            if(sudoku[row][i] == digit) return false;
        }

        // check in curr 3x3 box/grid
        int startingRow = (row/3)*3;
        int startingCol = (col/3)*3;
        for(int i=startingRow; i< startingRow+3; i++) {
            for(int j=startingCol; j< startingCol+3; j++) {
                if(sudoku[i][j] == digit) return false;
            }
        }

        return true;
    }


    public static void printSudoku(int[][] sudoku) {
        int n = sudoku.length;
        System.out.println("---------- sudoku solution ----------");

        for(int i=0; i<n; i++) {
            for(int j=0; j<n ; j++) {
                System.out.print(sudoku[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoku[][] = {
                {1, 0, 0, 9, 0, 7, 0, 0, 0},
                {7, 0, 0, 0, 0, 6, 9, 0, 4},
                {0, 0, 0, 0, 0, 4, 0, 1, 0},
                {0, 0, 0, 0, 0, 8, 2, 7, 0},
                {0, 0, 8, 5, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 7, 0, 0, 0, 5},
                {2, 6, 0, 0, 0, 9, 0, 0, 0},
                {0, 0, 7, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 4, 9, 0}
        };

        if(sudokuSolver(sudoku, 0, 0)) {
            System.out.println("\nSolution exists :");
            printSudoku(sudoku);
        } else {
            System.out.println("\nsolution doesn't exist !!");
        }
    }
}
