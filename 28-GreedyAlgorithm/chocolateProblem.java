// chocola (chocolate) problem : 

/**
 * we are given a bar of chocolate composed of mxn square pieces. one should 
 * break the chocolate into single squares. each break of a part of the chocolate in charged
 * a cost expressed by a positive integer. this cost doest no depend on the size 
 * of the part that is being broken but only depends on the line the break goes along. let us 
 * denote the costs of breaking along consecutive vertical lines with x1, x2 ..., xm-1 and along
 * horizontal line with y1, y2, ..., ym-1.
 * 
 * compute the minimal cost of breaking the whole chocolate into single squares.
*/

import java.util.*;

public class chocolateProblem {
    public static void main(String[] args) {
        int n=4, m=6;
        Integer verticalCost[] = {2, 1, 3, 1, 4};
        Integer horizontalCost[] = {4, 1, 2};

        Arrays.sort(verticalCost, Collections.reverseOrder());
        Arrays.sort(horizontalCost, Collections.reverseOrder());

        int h=0, v=0; // pointers
        int hp=1, vp=1; // count for the pieces
        int cost=0;

        while(h<horizontalCost.length && v<verticalCost.length) {
            // vertical cost < hor cost
            if(verticalCost[v] <= horizontalCost[h]) { // horizontal cut
                cost += (horizontalCost[h]*vp);
                hp++;
                h++;
            } else { // vertical cut
                cost += (verticalCost[v]*hp);
                vp++;
                v++;
            }
        }

        while(h<horizontalCost.length) {
            cost += (horizontalCost[h]*vp);
            hp++;
            h++;
        }
        while(v<verticalCost.length) {
            cost += (verticalCost[v]*hp);
            vp++;
            v++;
        }

        System.out.println("min cost to cut the chocolate: " + cost);
    }
}
