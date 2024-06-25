package programmers;

public class 없는_숫자_더하기 {
    public int solution(int[] numbers) {
        int[] count = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int number : numbers) {
            count[number] = 0;
        }

        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
