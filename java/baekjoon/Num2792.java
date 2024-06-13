package baekjoon;

import java.io.*;
import java.util.*;

public class Num2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] k = new int[m];
        int mk = 0;
        for (int i = 0; i < m; i++) {
            k[i] = Integer.parseInt(br.readLine());
            mk = Math.max(mk, k[i]);
        }

        int result = binarySearch(mk, n, k);
        System.out.println(result);
    }

    private static int binarySearch(int mk, int n, int[] k) {
        int min = Integer.MAX_VALUE;

        int start = 1;
        int end = mk;

        while (end >= start) {
            int mid = (start + end) / 2;
            int count = method(mid, k);
            if (count <= n) {
                min = Math.min(min, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return min;
    }

    private static int method(int mid, int[] k) {
        int count = 0;
        for (int i = 0; i < k.length; i++) {
            count += k[i] / mid;
            if (k[i] % mid != 0) {
                count += 1;
            }
        }
        return count;
    }
}
