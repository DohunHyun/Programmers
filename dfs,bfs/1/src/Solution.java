class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        answer = dfs(numbers, target, 0, 0);

        return answer;


    }

    private int dfs(int[] numbers, int target, int n, int sum) {

        if(n == numbers.length) { // 끝까지 다 돌았을때
            if(sum == target) answer++;
        } else {
            dfs(numbers, target, n+1, sum+numbers[n]);
            dfs(numbers, target, n+1, sum-numbers[n]);
        }

        return answer;
    }
}