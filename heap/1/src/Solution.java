import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue pq = new PriorityQueue();

        for(int a : scoville) {
            pq.add(a);
        }

        for(int i=0; i<scoville.length; i++) {
            if((int)pq.peek() >= K) break;
            if(i == scoville.length-1) {
                answer = -1;
                break;
            }
            int a = (int)pq.poll();
            int b = (int)pq.poll();

            pq.add(a + b*2);
            answer++;
        }


        return answer;
    }

}
