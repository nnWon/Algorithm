package programmers;

public class 숫자의_표현 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (n <= sum) {
                    if (n == sum) answer++;
                    break;
                }

            }
        }
        return answer;
    }
}
