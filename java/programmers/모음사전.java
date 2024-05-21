package programmers;

public class 모음사전 {

    static char[] alphabets = {'A', 'E', 'I', 'O', 'U'};
    static int count = 0;

    public int solution(String word) {
        return method("", word);
    }

    public int method(String s, String word) {
        for (char alphabet : alphabets) {
            count++;
            String newS = s + alphabet;

            if (word.equals(newS)) {
                return count;
            } else {
                if (newS.length() < 5) {
                    int result = method(newS, word);
                    if (0 < result) {
                        return count;
                    }
                }
            }
        }
        return -1;
    }
}
