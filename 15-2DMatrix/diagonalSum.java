// microsoft, samsung, amazon

public class diagonalSum {

    public static int getDiagonalSum(int[][] matrix) {
        int sum = 0;
        // MY OWN CODE (2n)
        // for(int i=0;i<matrix.length;i++) {
        //     sum += matrix[i][i];
        // }

        // for(int i=0, j=matrix.length - 1; i < matrix.length && j >= 0; i++, j--) {
        //     sum += matrix[i][j];
        // }


        // O(n^2)
        // for( int i=0; i<matrix.length; i++) {
        //     for (int j=0; j<matrix . length; j++) {
        //          if (i == j) {
        //              sum += matrix[i][j];
        //          }
        //          else if(i+j == matrix.length—1) {
        //              sum += matrix[i][j];
        //          }
        //      }
        // }

        // O(n) -> optimized code
        for(int i=0;i<matrix.length;i++) {
            // for primary diagonal
            sum += matrix[i][i];

            // for secondary diagonal
            //same as mycode but we removed j with equation (n-i-1), with this change we removed one whole loop
            if(i != matrix.length-i-1) { //don't add middle element therefore we are checking != not condition
                sum += matrix[i][matrix.length-i-1];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int [][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        System.out.println("sum => " + getDiagonalSum(matrix));
    }
}
