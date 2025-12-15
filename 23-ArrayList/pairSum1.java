import java.util.ArrayList;
import java.util.List;

public class pairSum1 {
    public static boolean find(ArrayList<Integer> nums, int target) {
        int lp = 0, rp = nums.size() - 1;

        while(lp != rp) {
            if(nums.get(lp) + nums.get(rp) == target) return true;
            
            if(nums.get(lp) + nums.get(rp) < target) lp++;
            else rp--;
        }

        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.addAll(List.of(1,2,3,4,5,6));
        System.out.println(find(nums, 5));
    }
}
