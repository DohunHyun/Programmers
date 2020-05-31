public class Solution {
    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};

        System.out.println(solution(answers));

    }

    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] first = new int[answers.length];
        int[] second = new int[answers.length];
        int[] third = new int[answers.length];


        int forfirst = 1;
        for (int i = 0; i < answers.length; i++) {
            first[i] = forfirst++;
            if (forfirst == 6) forfirst = 1;
        }

        for (int i = 0; i < answers.length; i++) {
            if (i % 2 == 0) second[i] = 2;
            else if (i % 8 == 1) { // 1,3,4,5
                second[i] = 1;
            } else if (i % 8 == 3) {
                second[i] = 3;
            } else if (i % 8 == 5) {
                second[i] = 4;
            } else if (i % 8 == 7) {
                second[i] = 5;
            }
        }

        for (int i = 0; i < answers.length; i++) {
            if (i % 10 == 0 || i % 10 == 1) {
                third[i] = 3;
            } else if (i % 10 == 2 || i % 10 == 3) {
                third[i] = 1;
            } else if (i % 10 == 4 || i % 10 == 5) {
                third[i] = 2;
            } else if (i % 10 == 6 || i % 10 == 7) {
                third[i] = 4;
            } else if (i % 10 == 8 || i % 10 == 9) {
                third[i] = 5;
            }
        }

        int[] score = {0, 0, 0};
        int firstscore = 0, secondscore = 0, thirdscore = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i]) firstscore++;
            if (answers[i] == second[i]) secondscore++;
            if (answers[i] == third[i]) thirdscore++;
        }

        int max = firstscore;
        if(secondscore > max) max = secondscore;
        if(thirdscore > max) max = thirdscore;

        int size=0;
        if(max == firstscore) size++;
        if(max == secondscore) size++;
        if(max == thirdscore) size++;

        answer = new int[size];

        int t = 0;
        if(max == firstscore) answer[t++] = 1;
        if(max == secondscore) answer[t++] = 2;
        if(max == thirdscore) answer[t++] =3;


        return answer;
    }
}
