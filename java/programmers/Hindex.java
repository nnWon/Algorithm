package programmers;

import java.util.*;

public class Hindex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            int count = citations[i];
            int numberOfCitation = citations.length - i;
            int h = Math.min(count, numberOfCitation);
            max = Math.max(h, max);
        }
        return max;
    }
}
