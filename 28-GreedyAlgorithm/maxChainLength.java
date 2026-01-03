// same pattern as activity selection

import java.util.Arrays;
import java.util.Comparator;

public class maxChainLength {
    public static void main(String[] args) {
        int[][] chains = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        // sort according to the end of chains
        Arrays.sort(chains, Comparator.comparingDouble(o -> o[1]));

        int maxChainLength = 0;
        int lastSelectedChainEnd = 0;

        // select 1st chain
        maxChainLength++;
        lastSelectedChainEnd = chains[0][1];

        for(int i=1;i<chains.length;i++) {
            // if the curr chain starts after the last selected chain then select the curr chain
            // start of curr chain >= end of last chain
            if(chains[i][0] >= lastSelectedChainEnd) { 
                maxChainLength++;
                lastSelectedChainEnd = chains[i][1];
            }
        }

        System.out.println("Max possible chain length: " + maxChainLength);
    }
}
