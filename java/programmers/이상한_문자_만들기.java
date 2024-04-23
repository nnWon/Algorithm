package programmers;

/**
 * //문자열을 문자 배열로 바꿈
 * //StringBuilder result
 *         //for문
 *              //공백이니? -> 추가하고 count = 0;
 *              //아니면 count % 2 ==0 이면 대문자, 아니면 소문자 추가
 *                  // count ++
 */
public class 이상한_문자_만들기 {
    public String solution(String s) {
        //
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (char target : s.toCharArray()) {
            if (target == ' ') {
                count = 0;
            } else if (count % 2 == 0) {
                target = Character.toUpperCase(target);
                count++;
            } else {
                target = Character.toLowerCase(target);
                count++;
            }
            result.append(target);
        }

        return result.toString();
    }
}
