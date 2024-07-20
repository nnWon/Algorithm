package programmers;

import java.util.*;

public class 단어_변환 {
    public int solution(String begin, String target, String[] words) {

        if (!isExistTarget(target, words)) {
            return 0;
        }

        Map<String, Boolean> visited = new HashMap<>();
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(0, begin));

        while (!queue.isEmpty()) {
            Word curWord = queue.poll();

            //로직
            if (curWord.word.equals(target)) {
                return curWord.count;
            }

            //다음 상태 생성
            for (String nextWord : words) {
                if (isPossibleChange(curWord.word, nextWord)) {
                    //방문한 적 있는지 확인
                    if (!visited.getOrDefault(nextWord, false)) {
                        visited.put(nextWord, true);
                        queue.add(new Word(curWord.count + 1, nextWord));
                    }
                }
            }
        }

        return 0;
    }

    private boolean isPossibleChange(String word, String target) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    private boolean isExistTarget(String target, String[] words) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }

    static class Word {
        int count;
        String word;

        public Word(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }
}

/*

//Word 클래스 - count, word
//words에 target 없으면 return 0

//1. 방문 여부 Map<String,Boolean> visited
//2. Queue 생성 & 초기화 & begin 삽입 : new Word(0,begin)
//3. Queue 루프 & curWord = poll
//4. 로직
    // curWord.word == target 이냐? 그럼 return Word.count
//5. 다음 상태 생성
    // words 반복문
    // curWord.word와 알파벳 하나만 다른 것을 찾는다.(String nextWord)
    // 5-1. 방문 확인 -> 있으면 continue
        //없으면 Queue.add(new Word(curWord.count+1,nextWord))

//return 0;
*/
