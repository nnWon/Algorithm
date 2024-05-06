package programmers;

public class 숫자_문자열과_영단어 {
    public int solution(String s) {
        String[] eNumbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < eNumbers.length; i++) {
            s = s.replace(eNumbers[i], i + "");
        }
        return Integer.parseInt(s);
    }
}
