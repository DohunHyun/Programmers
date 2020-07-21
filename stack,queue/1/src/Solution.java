import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(2, 10, truck_weights ));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int bridge_weight = 0;
        int time = 0;
        int truck_order = 0;

        Queue<Truck> bridge = new LinkedList();

        while(truck_order < truck_weights.length) { //다 지나갈때까지
            time++;

            if(!bridge.isEmpty()) { // bridge is not empty
                Truck firstTruck = bridge.peek(); //for check
                if(time - firstTruck.entertime == bridge_length) { // pass
                    bridge_weight -= bridge.poll().weight; // poll truck
                }
            }

            int tempTruck = truck_weights[truck_order];
            if(bridge_weight + tempTruck <= weight) { // 추가 가능
                bridge.offer(new Truck(tempTruck, time));
                truck_order++;
                bridge_weight += tempTruck;
            }


        }

        time += bridge_length; //for last truck;

        return time;
    }
}

class Truck {
    int weight;
    int entertime;

    Truck(int weight, int entertime) {
        this.entertime = entertime;
        this.weight = weight;
    }
}
