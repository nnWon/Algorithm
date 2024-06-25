package programmers;

import java.util.*;

public class A로_B만들기 {
    public int solution(String before, String after) {
        Map<Character, Integer> beforeMap = createMap(before);
        Map<Character, Integer> afterMap = createMap(after);
        for (char afterKey : afterMap.keySet()) {
            int count = afterMap.get(afterKey);
            if (beforeMap.get(afterKey) == null || beforeMap.get(afterKey) != count) {
                return 0;
            }
        }
        return 1;
    }

    private Map<Character, Integer> createMap(String before) {
        Map<Character, Integer> result = new HashMap<>();

        for (char c : before.toCharArray()) {
            int count = result.getOrDefault(c, 0);
            result.put(c, count + 1);
        }

        return result;
    }
}
