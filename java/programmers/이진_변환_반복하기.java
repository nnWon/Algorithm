package programmers;

/*
// answer [변환횟수,제거0개수] 선언
// while문 s가 100 이냐?
    //s 반환하는 함수
    // for문 0 제거
        //0 이면 zeroRemoveCount++
        //아니면 문자열 추가
    // answer[1] += zeroRemoveCount
    // Integer.toString(0 제거한 str.length(),2)
    //answer[0] += 1
// answer 반환
 */

public class 이진_변환_반복하기 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = {0, 0};
            while (!s.equals("1")) {
                //0 제거
                StringBuilder sb = new StringBuilder();
                int zeroRemoveCount = 0;
                for (char c : s.toCharArray()) {
                    if (c == '0') {
                        zeroRemoveCount++;
                    } else {
                        sb.append(c);
                    }
                }
                answer[1] += zeroRemoveCount;
                //길이를 2진법으로
                s = Integer.toString(sb.length(), 2);
                answer[0] += 1;
            }
            return answer;
        }
    }
}
