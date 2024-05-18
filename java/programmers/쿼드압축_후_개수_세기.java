package programmers;

/**
 * // 상태 : (s, [n,m])
 * 	시작 인덱스 n,m
 * 	배열 크기 s
 *
 * // 종료 조건
 * 	- s = 1 -> 답 [x,y]의 값 ++
 * 	- 시작 인덱스부터 끝 인덱스까지 모두 값이 일치함 -> 해당 값 ++
 *
 * 	// 점화식 (s, [n,m])-> (s/2, [n,m])
 * 				          (s/2, [n+(s/2) ,m])
 * 				          (s/2, [n,m+(s/2)])
 * 				          (s/2, [n+(s/2),m+(s/2)])
 */

public class 쿼드압축_후_개수_세기 {
    static int[] answer = {0, 0};
    static int[][] sArr;

    public int[] solution(int[][] arr) {
        sArr = arr;
        int s = arr.length;
        method(s, 0, 0);
        return answer;
    }

    public void method(int size, int startIndex, int endIndex) {
        if (size <= 1) {
            answer[sArr[startIndex][endIndex]] += 1;
            return;
        }

        boolean allMatch = true;
        int target = sArr[startIndex][endIndex];

        for (int x = startIndex; x < startIndex + size; x++) {
            for (int y = endIndex; y < endIndex + size; y++) {
                if (target != sArr[x][y]) {
                    allMatch = false;
                    break;
                }
            }
            if (!allMatch) {
                break;
            }
        }

        if (allMatch) {
            answer[target] += 1;
            return;
        }

        int nextSize = size / 2;
        method(nextSize, startIndex, endIndex);
        method(nextSize, startIndex + nextSize, endIndex);
        method(nextSize, startIndex, endIndex + nextSize);
        method(nextSize, startIndex + nextSize, endIndex + nextSize);

    }
}
