package leetcode;

import java.util.*;

public class Num1091 {

    int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};//동서남북 2,4,8,11
    int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        if (grid[0][0] == 1 || grid[rowLength - 1][colLength - 1] == 1) {
            return -1;
        }

        Position startPosition = new Position(0, 0, 1);

        boolean[][] visited = new boolean[rowLength][colLength];

        Queue<Position> queue = new LinkedList<>();
        queue.offer(startPosition);
        visited[startPosition.row][startPosition.col] = true;

        while (!queue.isEmpty()) {
            Position curPosition = queue.poll();

            if (curPosition.row == rowLength - 1 && curPosition.col == colLength - 1) { //목적지야?
                return curPosition.step;
            }

            for (int i = 0; i < 8; i++) { //8방향 반복
                int nextRow = curPosition.row + dx[i];
                int nextCol = curPosition.col + dy[i];
                if (0 <= nextRow && nextRow < rowLength && 0 <= nextCol && nextCol < colLength) {// 경계선 넘어?
                    if (!visited[nextRow][nextCol]) { //방문한 적 있어?
                        if (grid[nextRow][nextCol] == 0) { //이거 grid[][] == 0야?
                            visited[nextRow][nextCol] = true;
                            queue.offer(new Position(nextRow, nextCol, curPosition.step + 1));
                        }
                    }
                }
            }

        }
        return -1;

    }

    static class Position {

        int row;
        int col;
        int step;

        public Position(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
}
