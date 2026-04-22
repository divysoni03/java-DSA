package Ques;

public class floodFillAlgo {
    public static void helper(int[][] image, int sr, int sc, boolean[][] vis, int ogColor, int color) {
        if(sr<0 || sc<0 || sr>image.length-1 || sc>image[0].length-1 || vis[sr][sc] || image[sr][sc] != ogColor) {
            return;
        }

        vis[sr][sc] = true;
        image[sr][sc] = color;

        // left
        helper(image, sr, sc-1, vis, ogColor, color);

        // right
        helper(image, sr, sc+1, vis, ogColor, color);

        // up
        helper(image, sr-1, sc, vis, ogColor, color);

        // down
        helper(image, sr+1, sc, vis, ogColor, color);
    }

    public static void floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];

        helper(image, sr, sc, vis, image[sr][sc], color);
    }
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1, sc = 1, color = 2;
        floodFill(image, sr, sc, color);
        for(int[] i: image) {
            for(int j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
