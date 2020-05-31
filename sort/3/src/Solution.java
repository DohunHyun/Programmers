import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {

        int N = citations.length;
        int hIndex = 0;
        Arrays.sort(citations);

        while(true) {
            int count = 0;
            for(int temp : citations) { // 논문들 중에
                if(temp >= hIndex) { // h 이상 인용되면
                    count++; // 카운트 올려주고
                }
            }
            if(count >= hIndex && (N-count) <= hIndex) {
                hIndex++;
            } else {
                return hIndex-1;
            }
        }
    }
}
