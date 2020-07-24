import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        System.out.println(solution(prices));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> queue = new LinkedList();

        for(int temp : prices) {
            queue.add(temp);
        }

        for(int i=0; i<prices.length; i++) {
            int x = queue.poll();
            int second = 0;
            for(int temp : queue) {
                if(x <= temp) second++; // 가격이 떨어지지 않으면
                if(x > temp) { // 가격이 떨어지면
                    second++;
                    break;
                }
            }
            answer[i] = second;
        }

        return answer;
    }
}