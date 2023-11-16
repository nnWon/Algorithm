package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Num200 {

    int colLength;
    int rowLength;
    boolean[][] visited;
    char[][] grid;
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        int count = 0;
        this.rowLength = grid.length;
        this.colLength = grid[0].length;
        this.visited = new boolean[rowLength][colLength];
        this.grid = grid;

        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    bfs(r,c);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int r, int c) {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(r, c));

        while (!q.isEmpty()) {
            Position curPosition = q.poll();
            visited[curPosition.r][curPosition.c] = true;
            for (int i = 0; i < 4; i++) {
                int curR = curPosition.r + dr[i];
                int curC = curPosition.c + dc[i];
                if (0 <= curR && curR < rowLength && 0 <= curC && curC < colLength) { // x축 y축 경계면 넘으면 안됨
                    if (!visited[curR][curC]) { //방문한 적 있으면 안됨
                        if (grid[curR][curC] != '0') { //0이면 즉, 물이면 안됨
                            q.offer(new Position(curR, curC));
                            visited[curR][curC] = true;
                        }
                    }

                }
            }
        }
    }

    static class Position {
        int r;
        int c;

        public Position(int x, int y) {
            this.r = x;
            this.c = y;
        }
    }
}
