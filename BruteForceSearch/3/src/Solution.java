
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};


        int garo = 0;
        int sero = 0;

        for(int i=1; i<=yellow; i++) {
            for(int j=1; j<=i; j++) {

                if(i*j == yellow) {
                    if((i+j+4)*2 - 4 == brown) {
                        garo = i+2;
                        sero = j+2;
                        answer = new int[]{garo, sero};
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}