import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(11));
    }

    public static long solution(long n) {
        long answer = 0;

        long[] answerArray = new long[(int)n];
        int size=1;

        answerArray[0] = 1;


        for(int i =1; i<n; i++) {
            int temp = 0;
            answerArray[size++] = (long) Math.pow(3, i);
            temp = size;

           for(int j=0; j<temp-1; j++) {
               if((long) Math.pow(3, i) == answerArray[j]) break;
               if(size == n) break;
               answerArray[size++] = (long) Math.pow(3, i) + answerArray[j];
           }

            if(size == n) break;


        }
        answer = answerArray[(int)n-1];


        return answer;
    }
}