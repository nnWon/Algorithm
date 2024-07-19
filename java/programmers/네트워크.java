package programmers;

import java.util.*;

public class 네트워크 {

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int index = 0; index < computers.length; index++) {
            if (visited[index] == true) {
                continue;
            }
            checkNetwork(index, computers, visited);
            answer++;
        }
        return answer;
    }

    private void checkNetwork(int computer, int[][] computers, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(computer);

        while (!stack.isEmpty()) {
            int curCom = stack.pop();

            if (visited[curCom] == true) {
                continue;
            }
            visited[curCom] = true;

            for (int i = 0; i < computers[curCom].length; i++) {
                if (computers[curCom][i] == 1) {
                    if (visited[i] != true) {
                        stack.push(i);
                    }
                }
            }
        }
    }
}

/*
//방문 배열 선언 boolean[] visited
//computers 루프
    // visted[index] == true 면 continue
    // 아니면 checkNetwork
    // answer++;

//checkNetwork(int computer)
//2. 스택 초기화
    // 스택에 computer 넣기
//3.스택 루프 & 스택 팝
    // int curCom = 스택 팝
//4.방문 검사
    //visited[curCom] == true면 continue
    //visited[curCom] = true
//6.다음 상태 생성
    //computers[curCom] 루프
    // if computers[curCom][index] == 1 이냐?
        //visited[curCom] != true 이냐?
        // 그러면 stack.push(index)
*/
