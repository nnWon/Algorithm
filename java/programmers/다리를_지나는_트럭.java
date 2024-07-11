package programmers;

import java.util.*;

class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int count = 0;
        int curWeight = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            curWeight -= bridge.poll();

            if (curWeight + truck_weights[i] <= weight) {
                bridge.add(truck_weights[i]);
                curWeight += truck_weights[i];
            } else {
                bridge.add(0);
                i--;
            }
            count++;
        }

        while (!bridge.isEmpty()) {
            count++;
            bridge.poll();
        }

        return count;
    }
}
/*
    //bridege_length 만큼의 Queue 생성 -> 0으로 초기화
    //truck_weights 반복문
        // cur_weight -= Queue.poll()

        // 만약 cur_weight + truck[i] <= weigth
            //bridge.add(truck[i])
            //cur_weight += truck[i]
        // 넘으면
            //bridge.add(0)
            //i--;
        //시간++
    //while !Queue.isEmpty()
        //count++
        //queue.poll()
    //return count;
 */
