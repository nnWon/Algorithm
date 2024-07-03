package programmers;

import java.util.*;

class 괄호_회전하기 {
    public int solution(String s) {
        String[] targets = createStrArr(s);
        return method(targets);
    }

    private int method(String[] targets) {
        int count = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        for (String target : targets) {
            if (method2(target, map)) {
                count++;
            }
        }
        return count;
    }

    private boolean method2(String target, Map<Character, Character> map) {
        Stack<Character> s = new Stack<>();

        for (char c : target.toCharArray()) {
            switch (c) {
                case '(' -> s.push(')');
                case '{' -> s.push('}');
                case '[' -> s.push(']');
                case ')', '}', ']' -> {
                    if (s.isEmpty()) {
                        return false;
                    }
                    if (s.pop() != c) {
                        return false;
                    }
                }
            }
        }
        return s.isEmpty();
    }

    private String[] createStrArr(String s) {
        String[] result = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            result[i] = right + left;
        }
        return result;
    }
}
/*
    - 후보군 String[]을 만듦
    - method
        //count
        //method2 올바른 괄호 문자열인지 파악
        //count++
        //return count

     - method2
        //Stack 활용
 */

