import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(solution(progresses, speeds));

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList();
        int clear = progresses.length;

        Queue<item> queue = new LinkedList();

        for(int i = 0; i<progresses.length; i++) {
            queue.add(new item(progresses[i], speeds[i]));
        }

        while(clear > 0) {
            int count = 0;

            while(!queue.isEmpty()&&queue.peek().progress>=100) { // 진행도가 100 넘어가면 뽑고 카운트++
                queue.poll();
                count++;
                clear--;
            }

            for(int j=0; j<queue.size(); j++) { // 큐에 있는만큼 반복
                item temp = queue.poll();
                queue.add(new item(temp.progress + temp.speed, temp.speed) );
            }

            if(count > 0) { // 일 마친게 있다면
                answer.add(count);
            }


        }


        int[] returnArray = new int[answer.size()];

        for(int k=0; k<answer.size(); k++) {
            returnArray[k] = answer.get(k);
        }


        return returnArray;
    }
}

class item {
    int progress;
    int speed;

    public item(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}