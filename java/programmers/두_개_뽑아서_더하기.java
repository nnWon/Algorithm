package programmers;

import java.util.*;

public class 두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {

        //for문으로 돌면서 연산한다.
        Set<Integer> answer = new HashSet<>();
        for (int left = 0; left < numbers.length - 1; left++) {
            for (int right = left + 1; right < numbers.length; right++) {
                int result = numbers[left] + numbers[right];
                //결과를 HashSet에 담는다.
                answer.add(result);
            }
        }
        // HashSet을 정렬하고 int[]로 변환한다.
        return answer.stream()
                .sorted()
                .mapToInt(i -> i)
                .toArray();
    }
}
