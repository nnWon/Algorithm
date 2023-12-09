package programmers;

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {

        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else {
                if (stack.empty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
