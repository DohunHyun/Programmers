import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        int[] numbers = {3,30,34,5,9};
        System.out.println(solution(numbers));

    }

    public static String solution(int[] numbers) {
        String answer = "";
        String[] stringarray = new String[numbers.length];
        int size=0;

        for(int temp : numbers) {
            stringarray[size++] = Integer.toString(temp);
        }

        Arrays.sort(stringarray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                Integer.parseInt(o1);
                int n1 = Integer.valueOf(o1.charAt(0));
                int n2 = Integer.valueOf(o2.charAt(0));
                if(n1==n2) {
                    return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
                }
                return n2-n1;
            }
        });

        for(String temp : stringarray) {
            answer += temp;
        }

        if(answer.charAt(0) == '0') return "0";

        return answer;
    }
}
