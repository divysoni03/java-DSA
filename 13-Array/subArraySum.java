// sum of sub arrays & also print maximum and minimum of this 

import java.util.ArrayList;
import java.util.List;

public class subArraySum {
    public static void main(String[] args) {
        int [] arr = {2, 4, 6, 8, 10};

        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int sum = 0;
                for(int k=i; k<=j; k++) {
                    sum += arr[k];
                    System.out.print(arr[k] + " ");
                }
                ans.add(sum);
                System.out.println();
            }
            System.out.println();
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i: ans) {
            if(max < i) {
                max = i;
            }
            if(min > i) {
                min = i;
            }
        }

        System.out.println("Max : " + max);
        System.out.println("Min : " + min);
    }
}

