import java.util.Arrays;
import java.util.Comparator;

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

        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return  (o1[1]-o1[0]) - (o2[1] - o2[0]);
            }
        });

        for(int i=0; i<jobs.length; i++) {

            if(time >= array[i][0]) { // 시간이 이미 지났거다 왔으면
                time+= array[i][1];
                answer += time-array[i][0];
            }
            else {
                time ++;
                i--;
            }
        }

        // 만약 시간이 됐는데 먼저시작하는게 나은지 조금 기다렸다가 하는게 나은지도 체크해야하네 ;;
        // 





        return answer/jobs.length;
    }
}
