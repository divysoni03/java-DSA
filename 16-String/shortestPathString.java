// finding displacement from two points 
// input will be str = "wneenesennn"
// root ((x2-x1)^2 + (y2-y1)^2)

public class shortestPathString {
    public static void main(String[] args) {
        String str = "wneenesennn".toLowerCase();
        int x = 0 ,y = 0;
        for(char i : str.toCharArray()) {
            switch(i) {
                case 'n':
                    y++;break;
                case 's':
                    y--;break;
                case 'e':
                    x++;break;
                case 'w':
                    x--;break;
                default :
                    System.out.println("Invalid input.");
                    break;
            }
        }

        System.out.println("\n\nshortest distance : " + Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }
}
