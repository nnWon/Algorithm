package programmers;

import java.util.*;

class 정수_삼각형 {

    private int[][] mem = new int[501][501];

    public int solution(int[][] triangle) {
        for (int[] arr : mem) {
            Arrays.fill(arr, -1);
        }
        return method(0, 0, triangle);
    }

    private int method(int h, int w, int[][] triangle) {
        if (h == (triangle.length - 1)) {
            return mem[h][w] = triangle[h][w];
        }

        if (mem[h][w] != -1) {
            return mem[h][w];
        }

        int max = Math.max(method(h + 1, w, triangle), method(h + 1, w + 1, triangle));
        return mem[h][w] = triangle[h][w] + max;
    }
}

//mem[h][w] = 나올 수 있는 최대값을 저장한다.
//method (int h, int w)
// 종료조건 주어진 h가 triangle.length-1 면 return  mem[h][w] = triangle[h][w]; -> 예제에서는 h = 4일 경우
// 만약 mem[h][w] != -1 이 아니면 return mem[h][w]
// 이면 max = Math.max(method(h+1,w,triangle), method(h+1,w+1,triangle))
// return mem[h][w] = triangle[h][w]+max;
