package programmers;

public class 자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        String reverseStr = new StringBuilder(n + "").reverse().toString();
        String[] sArr = reverseStr.split("");
        int[] answer = new int[sArr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(sArr[i]);
        }
        return answer;
    }
}
