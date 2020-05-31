import java.util.HashSet;

public class Solution {

    static HashSet hashSet = new HashSet();

    public static void main(String[] args) {
        String numbers = "123";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        String[] array = numbers.split("");

        for (int i = 1; i <= array.length; i++) { //i는 몇개 뽑아 쓸지
            perm(array, 0, array.length, i); // 숫자를 다 이용한 경우
        }

        return hashSet.size();
    }

    public static void perm(String[] array, int depth, int n, int k) {
        if (depth == k) {

            String temp = ""; // array에 있는 배열로 숫자 만들어주고
            for (int i = 0; i < k; i++) {
                temp += array[i];
            }
            int tempInt = Integer.parseInt(temp);

            if (check(tempInt) == 1) { // 소수이면
                hashSet.add(tempInt);
            }
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(array, i, depth);
            perm(array, depth + 1, n, k);
            swap(array, i, depth);
        }
    }

    private static int check(int tempInt) {

        int isSosu = 1; // 0일때 소수 아님 1일때 소수
        if(tempInt == 0 || tempInt == 1) return 0;
        for (int i = 2; i <= Math.sqrt(tempInt); i++) {
            if (tempInt % i == 0) { // 나누어 떨어지면 소수가 아님
                isSosu = 0;
                break;
            }
        }
        if (isSosu == 0) { // 소수가 아니면
            return 0; // 소수가 아님
        } else {
            return 1; //소수이다
        }
    }

    private static void swap(String[] array, int i, int depth) {
        String temp = array[i];
        array[i] = array[depth];
        array[depth] = temp;
    }
}
