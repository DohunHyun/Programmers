class Solution {
    int answer = 0;

    public int solution(int n, int[][] computers) {

        //하나하나 다 돌면서
        // check 확인하고, 만약 안갔으면 answer++
        // 만약 갔었으면 다음 
        int[] check = new int[computers.length];

        for(int i=0; i<computers.length; i++) {
            if(check[i] == 1) { // 방문 했다면 

            } else { // 방문 안했으면 

                //연결되어있는거 다 방문처리
                visit(computers, check, i);
                answer++;
            }
        }

        return answer;
    }
    public void visit(int[][] computers, int[] check, int i) {
        // i에 방문을 하고, 그거랑 연결된거 다 방문처리하기.
        if(check[i] == 1) { //방문 했으면 
            return;
        }
        if(check[i] == 0) { //방문 안했으면
            check [i] = 1;
            for(int j=0; j<computers.length; j++) {
                if(computers[i][j] == 1) {
                    visit(computers, check, j);
                }
            }
        }

    }
}