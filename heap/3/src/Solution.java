import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] jobs = {{0,3}, {4,9}, {2,6}};

        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int[][] array = jobs.clone();
        int time = 0;

        Arrays.sort(jobs, new Comparator<int[]>() { //jobs 배열 들어온 시간순대로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

//        Arrays.sort(array, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return  (o1[1]-o1[0]) - (o2[1] - o2[0]);
//            }
//        });
//
//        for(int i=0; i<jobs.length; i++) {
//
//            if(time >= array[i][0]) { // 시간이 이미 지났거다 왔으면
//                time+= array[i][1];
//                answer += time-array[i][0];
//            }
//            else {
//                time ++;
//                i--;
//            }
//        }

        // 만약 시간이 됐는데 먼저시작하는게 나은지 조금 기다렸다가 하는게 나은지도 체크해야하네 ;;
        //

        Queue<int[]> queue = new LinkedList();
        int order = 0;

        while(queue.isEmpty()) {
            while(jobs[order][0] <= time) { // 시간이 되면 큐에 넣어주기
                queue.add(jobs[order]); // {0,3}
            }

            if(queue.peek()[0] <= time) {
                while(queue.peek()[0] <= time) { // 큐에 나올 일이 시간이 다되면
                    answer += time+queue.peek()[1]; // 총 시간에 소요 시간 더해주기
                    time += queue.poll()[1];
                    if(queue.isEmpty()) break;
                }

            } else {
                time++;

            }


        }





        return answer/jobs.length;
    }
}
