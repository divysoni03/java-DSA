import java.util.*;

public class activitySelection {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        // already sorted but if not then...
        int[][] activities = new int[start.length][3];
        for(int i=0;i<start.length;i++) {
            activities[i][0] = i; // first col is for activity index
            activities[i][1] = start[i]; // second col is for start time for particular activity
            activities[i][2] = end[i];
        }

        // sorting 2d arr
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxActivities = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // selecting the 1st activity
        maxActivities = 1;
        ans.add(activities[0][0]);
        int lastEndTime = activities[0][2];

        for(int i=1;i<start.length;i++) {
            if(activities[i][1] <= lastEndTime) {
                maxActivities++;
                ans.add(activities[i][0]);
                lastEndTime = activities[i][2];
            }
        }

        System.out.println("Max number of activities Done :" + maxActivities);
        for(int i=0;i<ans.size();i++) {
            System.out.print("A" + ans.get(i) + ", ");
        }
        System.out.println();
    }
}
