import java.util.ArrayList;
import java.util.Collections;

public class jobScheduling {
    static class Job {
        int id;
        int deadLine;
        int profit;

        public Job(int id, int deadLine, int profit) {
            this.id = id;
            this.deadLine = deadLine;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        int[][] jobInfo = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0;i<jobInfo.length;i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (a, b)->b.profit-a.profit); // custom comparator function to compare the objects 

        ArrayList<Integer> ans = new ArrayList<>();
        int time=0;
        int totalProfit=0;
        for(int i=0;i<jobs.size();i++) {
            Job currJob = jobs.get(i);
            //  if currJob deadline is not passed by the time 
            if(currJob.deadLine > time) {
                ans.add(i);
                totalProfit+=currJob.profit;
                time++;
            }
        }

        System.out.println("max jobs done: "+ans.size());
        System.out.println("total profit: " + totalProfit);
        for(int i=0;i<ans.size();i++) {
            System.out.print(ans.get(i) + ", ");
        }
        System.out.println();
    }
}
