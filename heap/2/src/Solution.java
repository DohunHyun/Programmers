import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {4,10,15};
        int[] supplies = {20,5,10};
        int k = 30;

        System.out.println(solution(stock, dates, supplies, k));

    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int i =0;
        while(stock<k) {
            while(i < dates.length && stock >= dates[i]) {
                pq.add(supplies[i]);
                i++;
            }
            stock += pq.poll();
            answer++;
        }

        return answer;
    }
}
