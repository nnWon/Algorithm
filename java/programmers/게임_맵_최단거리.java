package programmers;

import java.util.*;

public class 게임_맵_최단거리 {

    private final int[][] UDLR = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        int[][] visited = new int[n][m];
        Queue<Position> queue = new LinkedList<>();
        Position first = new Position(0, 0, 1);
        queue.add(first);

        while (!queue.isEmpty()) {
            Position curP = queue.poll();
            //로직
            if (curP.row == n - 1 && curP.col == m - 1) {
                return curP.count;
            }

            //다음 상태 생성
            for (int[] xy : UDLR) {
                int x = xy[0] + curP.row;
                int y = xy[1] + curP.col;
                Position nextP = new Position(x, y, curP.count + 1);
                //범위 검사
                if (!(0 <= nextP.row && nextP.row < n && 0 <= nextP.col && nextP.col < m)) {
                    continue;
                }
                // 유효성 검사
                if (maps[nextP.row][nextP.col] == 0) {
                    continue;
                }
                //방문 검사
                if (visited[nextP.row][nextP.col] == 1) {
                    continue;
                }
                visited[nextP.row][nextP.col] = 1;
                queue.add(nextP);
            }

        }

        return -1;
    }
}

class Position {
    int row;
    int col;
    int count;

    public Position(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }

    @Override
    public String toString() {
        return "[" + row + "," + col + "] " + count;
    }
}

/*
//Class Position
    //현재 위치 row,col
    // int count

//1.방문 배열 선언
//2.Queue 선언과 add, 방문 처리
//3.Queue 루프
//4.로직
    // 현재 위치 (n,m) 이냐? return count

//5.다음 상태 생성
    // 상하좌우 Postion 객체 생성
    // 상하좌우 루프
        //5-1.범위 검사
            // 0<= r < n AND 0 <= c < m 이냐? -> 아니면 continue
        //5-2.유효성 검사
            // map[r][c] == 1 이냐? -> 아니면 continue
        //5-4.방문 확인 , 방문 처리
            // visited[r][c] == 0 이냐? -> 아니면 continue
            //이면 visited[r][c] == 1
        //5-5. 다음 상태 add
            // Queue.add(position)
 */
