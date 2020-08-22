import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] jobs = {{0,3}, {4,9}, {2,6}};

        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        LinkedList<Job> waitingQ = new LinkedList<>(); // 대기 큐

        Queue<Job> workingQ = new PriorityQueue(new Comparator<Job>() { // 일 진행중인 큐
            @Override
            public int compare(Job o1, Job o2) {
                return o1.consumptionTime - o2.consumptionTime;
            }
        });

        for(int i=0; i<jobs.length; i++) { //대기 큐에 작업 등록
            waitingQ.offer( new Job(jobs[i][0], jobs[i][1]) );
        }


        // 큐 정렬
        Collections.sort(waitingQ, new Comparator<Job>() { // 요청 시간에 맞춰서 큐 정렬
            @Override
            public int compare(Job o1, Job o2) {
                return o1.requestTime - o2.requestTime;
            }
        });


        int doneJob = 0;
        int time = 0;

        while (doneJob < jobs.length) {
            while(!waitingQ.isEmpty() && time >= waitingQ.peek().requestTime) {
                workingQ.offer(waitingQ.poll());
            }

            if(!workingQ.isEmpty()) { // 일이 진행중이라면
                Job temp = workingQ.poll();
                time += temp.consumptionTime;
                answer += time - temp.requestTime;
                doneJob++;
            } else { //일이 없다면 시간 지나고 끝
                time++;
            }
        }
        return answer/jobs.length;
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