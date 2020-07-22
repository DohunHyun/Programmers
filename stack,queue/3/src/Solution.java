import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int weight = 0;


        Queue<Node> queue = new LinkedList<Node>();
        for(int i=0; i<priorities.length; i++) { //큐에 다 추가
            queue.add(new Node(i, priorities[i]));
        }

        while(!queue.isEmpty()) { //배열 크기만큼 반복
            Node x = queue.poll(); //첫번째 노드
            weight = x.weight; //첫째노드의 우선도
            int bigger = 0; //더 큰게 있으면 1로

            for(Node temp : queue) {
               if(temp.weight > weight) { // 뽑은것의 우선순위가 더 낮으면
                   bigger = 1; //표시 바꿔주고
                   break;
               }
            }
            if(bigger == 1) { //더 큰게 있으면 뽑은거 다시 넣어주고
                ((LinkedList<Node>) queue).add(x); //뽑았던거 다시 넣고
            } else { // 더 큰게 없으면 그냥 뽑은거 출력.
                answer++;
                if(x.location == location) { //찾는걸 출력했으면
                    return answer;
                }
            }
        }
        return answer;
    }
}
class Node {
    int location;
    int weight;

    public Node(int location, int weight) {
        this.location = location;
        this.weight = weight;
    }
}