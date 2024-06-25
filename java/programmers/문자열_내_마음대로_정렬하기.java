package programmers;

import java.util.Arrays;

public class 문자열_내_마음대로_정렬하기 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (v1, v2) -> {
            if (v1.charAt(n) == v2.charAt(n)) {
                return v1.compareTo(v2);
            }
            return v1.charAt(n) - v2.charAt(n);
        });
        return strings;
    }
}
