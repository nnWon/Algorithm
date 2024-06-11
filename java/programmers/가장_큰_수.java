package programmers;

import java.util.Arrays;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        int[] list = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int case1 = Integer.parseInt(s1 + s2);
                    int case2 = Integer.parseInt(s2 + s1);
                    return case2 - case1;
                })
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean allZero = true;
        for (int number : list) {
            if (number != 0) {
                allZero = false;
                break;
            }
        }

        if (allZero) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int number : list) {
            sb.append(number);
        }
        return sb.toString();
    }
}
