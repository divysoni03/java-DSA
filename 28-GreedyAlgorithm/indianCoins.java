import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;

public class indianCoins {
    public static void main(String[] args) {
        Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        Arrays.sort(coins, Comparator.reverseOrder());
        
        int minCoins = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        int Value = 590;

        int idx = 0;
        while(Value >= 0 && idx < coins.length) {
            // curr coin is less than or equal to the value then add that coin
            if(Value >= coins[idx]) {
                minCoins++;
                Value-= coins[idx];
                ans.add(coins[idx]);
            } else idx++;
        }

        System.out.println("min number of coins used: " + minCoins);
        for(int i=0;i<ans.size();i++) {
            System.out.print(ans.get(i) + ", ");
        }
        System.out.println();
    }
}
