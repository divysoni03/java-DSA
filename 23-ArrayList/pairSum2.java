import java.util.ArrayList;
import java.util.List;

public class pairSum2 {

    // my code
    public static boolean find(ArrayList<Integer> nums, int target) {
        int pivot = 0;
        for(int i=1;i<nums.size(); i++) {
            if(!(nums.get(i-1) < nums.get(i))) {
                pivot = i;
            }
        }

        int lp=pivot, rp = pivot-1;
        while(lp != rp) {
            // case 1
            if(nums.get(lp) + nums.get(rp) == target ) return true;

            // case 2
            if(nums.get(lp) + nums.get(rp) < target){
                lp += (lp+1) % nums.size();
            }
            // case 3
            else {
                // if(rp == 0) rp = nums.size()-1;
                // else rp--;
                rp = (nums.size()+rp-1) % nums.size();
            }
        }

        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.addAll(List.of(11,15,6,8,9,10));
        System.out.println(find(nums, 16));
    }
}
