package programmers;

import java.util.*;

public class K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        int cycle = commands.length;
        int[] answer = new int[cycle];

        for (int i = 0; i < cycle; i++) {
            int result = sortAndGet(array, commands[i]);
            answer[i] = result;
        }

        return answer;
    }

    private int sortAndGet(int[] array, int[] command) {
        //지정된 범위만큼 배열을 자른다.
        int from = command[0] - 1;
        int to = command[1] - 1;
        int k = command[2] - 1;
        int[] newArr = Arrays.copyOfRange(array, from, to + 1);
        // 새로운 배열을 정렬 Array.sort()
        Arrays.sort(newArr);
        // 지정된 인덱스를 반환
        return newArr[k];
    }
}
