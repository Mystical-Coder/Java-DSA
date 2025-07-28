package GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;


public class JobSeqProb {

    public static class Job {
        int profit;
        int id;
        int deadline;

        public Job(int profit, int id, int deadline){
            this.deadline = deadline;
            this.profit = profit;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        ArrayList<Job> list = new ArrayList<>();
        for(int i = 0; i < jobInfo.length; i++){
            list.add(new Job(jobInfo[i][1], i, jobInfo[i][0]));
        }

        Collections.sort(list, (a, b) -> b.profit - a.profit);
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i = 0; i < list.size(); i++){   
            Job job = list.get(i);
            if(job.deadline > time){
                time++;
                seq.add(job.id);
            }
        }
        System.out.println("Total job: " +time+ " Sequence : "+seq);
    }
}
