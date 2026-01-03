import java.util.*;

public class fractionalKnapSack {
    public static void main(String[] args) {
        int weight[] = {10, 20, 30};
        int value[] = {60, 100, 120};
        int W = 50;

        double ratio[][] = new double[weight.length][2];
        for(int i=0;i<weight.length;i++) {
            ratio[i][0] = i; // idx of item
            ratio[i][1] = value[i] / weight[i]; // ratio v/w
        }

        // ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); // sorting respect to 1st col

        int capacity = W, finalValue = 0;

        for(int i=ratio.length - 1;i>=0;i--) {
            int idx = (int) ratio[i][0];
            if(capacity >= weight[idx]) { // including whole item
                finalValue += value[idx];
                capacity -= weight[idx];
            } else { // including the fractional value and weight to knapsack
                finalValue += (ratio[i][1] * capacity); 
                capacity = 0;
                break;
            }
        }

        System.out.println("Max Value : " + finalValue);
    }
}
