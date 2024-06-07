package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 문자열_내림차순으로_배치하기 {
    public String solution(String s) {

        return Arrays.stream(s.split(""))
                .sorted((v1, v2) -> v2.charAt(0) - v1.charAt(0))
                .collect(Collectors.joining());
    }
}
