import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] jobs = {{0,3}, {4,9}, {2,6}};

        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        Queue waitingQ = new PriorityQueue();
        Queue workingQ = new PriorityQueue();

        for(int i=0; i<jobs.length; i++) {
            Job tempjob = new Job(jobs[i][0], jobs[i][1]);
        }

        // 큐 정렬








        return answer;
    }
}

class Job {
    int requestTime;
    int consumptionTime;

    Job(int requestTime, int consumptionTime) {
        this.requestTime = requestTime;
        this.consumptionTime = consumptionTime;
    }

}