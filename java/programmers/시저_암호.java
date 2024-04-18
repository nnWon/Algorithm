package programmers;

public class 시저_암호 {
    public String solution(String s, int n) {

        char[] charArr = s.toCharArray();
        StringBuilder answer = new StringBuilder();

        for (char c : charArr) {
            if (c == ' ') {
                answer.append(c);
            } else {
                int result = c + n;
                char endAlphabet = Character.isUpperCase(c) ? 'Z' : 'z';
                if ((int) endAlphabet < result) {
                    result -= ('z' - 'a' + 1);
                }
                answer.append((char) result);
            }
        }
        return answer.toString();
    }
}
