package programmers;

import java.util.*;

public class 수식최대화 {
    public long solution(String expression) {
        // 수식 우선순위 6개 선언
        String[][] priorities = createPriorities();
        // expression를 연산자 기준으로 분리
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> strList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            strList.add(st.nextToken());
        }

        long max = 0;
        //우선순위를 루프하면서 계산
        for (String[] priority : priorities) {
            List<String> target = new ArrayList<>(strList);
            long result = cal(target, priority);
            max = Math.max(max, Math.abs(result));
        }

        return max;
    }

    private long cal(List<String> target, String[] priority) {
        // 연산자를 루프
        for (String op : priority) {
            // target을 루프돌면서 연산자를 찾는다.
            for (int i = 0; i < target.size(); i++) {
                // 연산자를 발견하면 계산
                if (target.get(i).equals(op)) {
                    long result = method(target.get(i - 1), target.get(i + 1), op);
                    // i+1, i, i-1 제거
                    target.remove(i + 1);
                    target.remove(i);
                    target.remove(i - 1);
                    // result를 i-1에 추가
                    target.add(i - 1, result + "");
                    i = i - 1;
                }
            }
        }
        return Long.parseLong(target.get(0));
    }

    private long method(String pre, String suf, String op) {
        long numPre = Long.parseLong(pre);
        long numSuf = Long.parseLong(suf);

        if (op.equals("+")) {
            return numPre + numSuf;
        }
        if (op.equals("-")) {
            return numPre - numSuf;
        }
        if (op.equals("*")) {
            return numPre * numSuf;
        }
        return 0;
    }

    private String[][] createPriorities() {
        return new String[][]
                {"+-*".split(""),
                        "+*-".split(""),
                        "-+*".split(""),
                        "-*+".split(""),
                        "*+-".split(""),
                        "*-+".split("")};
    }
}
