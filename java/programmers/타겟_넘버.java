package programmers;

import java.util.Stack;

public class 타겟_넘버 {
    public int solution(int[] numbers, int target) {
        Stack<Num> stack = new Stack<>();
        stack.push(new Num(-1, 0));

        int result = 0;
        while (!stack.isEmpty()) {
            Num num = stack.pop();

            //로직
            if (num.index == numbers.length - 1) {
                if (num.sum == target) {
                    result++;
                }
                continue;
            }

            int nextIndex = num.index + 1;
            //다음 상태 생성
            Num plusNum = new Num(nextIndex, num.sum + numbers[nextIndex]);
            Num minusNum = new Num(nextIndex, num.sum - numbers[nextIndex]);
            stack.push(plusNum);
            stack.push(minusNum);

        }

        return result;
    }

    static class Num {
        int index;
        int sum;

        public Num(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }

    }
}
