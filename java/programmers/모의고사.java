package programmers;

import java.util.stream.*;

public class 모의고사 {
    public int[] solution(int[] answers) {

        Student s1 = new Student(new int[]{1, 2, 3, 4, 5});
        Student s2 = new Student(new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        Student s3 = new Student(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
        Student[] students = {s1, s2, s3};

        int[] counts = {0, 0, 0};
        int max = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            for (int sNum = 0; sNum < students.length; sNum++) {
                //정답이면 counts 증가시키고, 최대값인지 검사
                if (students[sNum].isCorrect(answer, i)) {
                    counts[sNum] += 1;
                    max = Math.max(max, counts[sNum]);
                }
            }
        }
        //자바에서는 람다, 익명 메서드에서 외부 변수를 참조할 때는 final 키워드를 붙여 값이 수정되지 않는다는 것을 명시해야 한다.
        final int fmax = max;

        return IntStream.range(0, 3)
                .filter(n -> counts[n] == fmax)
                .map(n -> n + 1)
                .toArray();
    }
}

class Student {

    int[] answers;

    public Student(int[] answers) {
        this.answers = answers;
    }

    public boolean isCorrect(int target, int index) {
        int i = index % answers.length;
        return answers[i] == target;
    }
}
