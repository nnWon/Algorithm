package programmers;

import java.util.*;

public class 중복된_문자_제거 {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        StringBuffer answer = new StringBuffer();
        for (char c : my_string.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                answer.append(c);
            }
        }
        return answer.toString();
    }
}
