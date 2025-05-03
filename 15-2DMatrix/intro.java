public class intro {
    public static void main (String[] args ) {
        // 2D array declaration
        // int[][] arr = new int[3][4]; // 3 rows and 4 columns

        // 2D array initialization
        int[][] arr1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        // Accessing elements in a 2D array
        System.out.println(arr1[0][0]); // Output: 1
        System.out.println(arr1[1][2]); // Output: 7

        // Iterating through a 2D array
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

    }
}