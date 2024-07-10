package programmers;

import java.util.*;

public class 기능_개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> days = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day += 1;
            }
            days.add(day);
        }

        List<Integer> result = new ArrayList<>();
        while (!days.isEmpty()) {
            int day = days.poll();
            int count = 1;
            while (!days.isEmpty() && days.peek() <= day) {
                days.poll();
                count++;
            }
            result.add(count);
        }

        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }

}
