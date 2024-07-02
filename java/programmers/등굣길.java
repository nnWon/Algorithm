package programmers;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        //물웅덩이 초기화
        boolean[][] isPuddles = createPuddles(m, n, puddles);

        //지도 초기화
        int[][] map = new int[n + 1][m + 1];
        map[1][1] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                //물웅덩이면 map[i][j] == 0
                if (isPuddles[i][j]) {
                    map[i][j] = 0;
                    continue;
                }

                //현재 위치가 출발지가 아니면
                if (!(i == 1 && j == 1)) {
                    int up = isOutside(i - 1, j) ? 0 : map[i - 1][j];
                    int left = isOutside(i, j - 1) ? 0 : map[i][j - 1];
                    map[i][j] = (up + left) % 1000000007;
                }
            }
        }
        return map[n][m];
    }

    private boolean[][] createPuddles(int m, int n, int[][] puddles) {
        boolean[][] isPuddles = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            int i = puddle[1];
            int j = puddle[0];
            isPuddles[i][j] = true;
        }
        return isPuddles;
    }

    private boolean isOutside(int i, int j) {
        if (i < 1) {
            return true;
        }
        if (j < 1) {
            return true;
        }
        return false;
    }
}

//isPuddles 초기화 boolean[][] isPuddles = new boolean[n+1][m+1]

//map 초기화 int[][] map = new int[n+1][m+1]
//map[1][1] = 1
//반복문 i=1~n+1, j=1~m+1
    //isPuddles[i][j]
        //map[i][j] = 0
        //continue
    //up = isOutside(i-1,j)
    //left = isOutside(i,j-1)
    //map[i][j] = up+left
//return map[n][m]
