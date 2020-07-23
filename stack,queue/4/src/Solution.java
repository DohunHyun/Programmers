import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";

        System.out.println(solution(arrangement));
    }

    public static int solution(String arrangement) {
        int answer = 0;
        int check = 0; // 막대 개수

        Queue<String> queue = new LinkedList();

        String[] line = arrangement.split("");
        queue.addAll(Arrays.asList(line));

        while(!queue.isEmpty()) { // 큐가 빌때까지 반복
            String temp = queue.poll();

            if(temp.equals("(")) {
                if(queue.peek().equals(")")) { // 레이저 인경우
                    queue.poll(); // 레이저 발사!!
                    answer += check; // 잘린 조각들 더해주기
                } else { // 막대 시작점
                    check++;
                }
            } else { // temp == ")"
                check--; // 막대 마지막점
                answer++; // 잘린 마지막 조각 더해주기
            }
        }
        
        return answer;
    }
}
