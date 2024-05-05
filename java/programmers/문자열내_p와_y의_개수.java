package programmers;

/*
// s를 소문자로 바꾼다. s.toLowerCase()
//p의 개수를 카운팅한다. O(n)
//y의 개수를 카운팅한다. O(n)
//개수를 비교한다.
 */
public class 문자열내_p와_y의_개수 {
    boolean solution(String s) {

        int pCount = 0;
        int yCount = 0;

        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p') {
                pCount++;
            }
            if (c == 'y') {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}
