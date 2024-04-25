package programmers;

import java.util.*;

/**
 *  //int min = s.length()+1;
 *         //for문 int zipSize = 1 ~ s.length()
 *         // result = 함수(s, zipSize);
 *         // min = Math.min(min,result)
 *   //함수
 *      //문자열을 zipSize에 맞게 나눔
 *      //배열을 돌면서 일치하는지 확인
 *          //for문
 *          //일치하면 count++
 *          //일치하지 않으면 i = j
 *              //result=count+str[j]
 *              //대신 count=0이면 생략
 */

public class 문자열_압축 {
    public int solution(String s) {
        int min = s.length(); //"aabbaccc"이면 min = 8
        for (int zipSize = 1; zipSize <= s.length(); zipSize++) {
            int result = zipStr(zipSize, s);
            min = Math.min(min, result);
        }
        return min;
    }

    private int zipStr(int zipSize, String s) {
        List<String> strList = new ArrayList<>();

        for (int start = 0; start < s.length(); start += zipSize) {
            int end = start + zipSize;
            if (end > s.length()){
                end = s.length();
            }
            strList.add(s.substring(start, end));
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < strList.size(); j++) {
            int count = 1;
            String result = strList.get(j);
            int k = j + 1;
            for (; k < strList.size(); k++) {
                if (strList.get(j).equals(strList.get(k))) {
                    count++;
                } else {
                    break;
                }
            }
            j = k - 1;
            if (count != 1) {
                result += count;
            }
            sb.append(result);
        }
        return sb.length();
    }

}

