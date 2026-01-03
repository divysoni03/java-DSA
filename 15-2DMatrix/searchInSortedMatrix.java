// oracle, adobe


// where given matrix is row wise sorted (every row is sorted) & also column wise sorted
// here we are doing binary search in every row so n * lon(n)
// this is also KNOWN AS STAIR CASE SEARCHING :-
public class searchInSortedMatrix {

    public static void getIndex(int[][] matrix, int target) {
        //starting from the top-right element of the matrix
        int i=0, j=matrix[0].length-1;

        // matrix.len == length of rows
        // matrix[0].len == length of cols

        while(i<=matrix.length-1 && j>=0) {
            System.out.println("i:"+i+", j:"+j+", val:"+matrix[i][j]);
            if(matrix[i][j] == target) {
                System.out.printf("Found At Key : (%d, %d)\n", i,j);
                break;
            } else if(matrix[i][j] > target) {
                j--;
            } else if(matrix[i][j] < target) {
                i++;
            } 
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        getIndex(matrix, 41);
    }
}
