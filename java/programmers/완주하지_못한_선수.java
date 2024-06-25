package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completionMap = createMap(completion);
        for (String part : participant) {
            int count = completionMap.getOrDefault(part, 0);
            if (count == 0) {
                return part;
            }
            completionMap.put(part, count - 1);
        }
        return "";
    }

    private Map<String, Integer> createMap(String[] completion) {
        Map<String, Integer> result = new HashMap<>();
        for (String com : completion) {
            int count = result.getOrDefault(com, 0);
            result.put(com, count + 1);
        }
        return result;
    }
}
