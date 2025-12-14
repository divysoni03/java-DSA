public class gridWaysProblem {

    public static int gridWays(int i, int j, int n, int m) {
        // two base cases
        if(i == n - 1 && j == m - 1) { // condition if we are on last cell
            return 1;
        } else if(i == n || j == n) { // if i or j crosses the boundary then we have to return 0(as there is no further ways)
            return 0;
        }

        // work
        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);

        return w1 + w2;
    }


    public static void printGridWay(char[][] grid) {
        System.out.println("------- grid way -------");
        for(int i=0;i< grid.length; i++) {
            for(int j=0;j< grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        System.out.println("\nTotal ways gridWays: "+ gridWays(0, 0, n, m));
    }
}
