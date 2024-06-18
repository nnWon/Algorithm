package baekjoon;

import java.io.*;
import java.util.*;

public class Num2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] lectures = new int[n];
        int sum = 0;
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            int lecture = Integer.parseInt(st.nextToken());
            lectures[i] = lecture;
            sum += lecture;
            maxTime = Math.max(maxTime, lecture);
        }

        int min = sum / m;
        int max = maxTime * m;


        System.out.println(binarySearch(min, max, m, lectures));
    }

    public static int binarySearch(int min, int max, int blueRay, int[] lectures) {
        int start = min;
        int end = max;
        int result = 0;
        while (end >= start) {
            int mid = (start + end) / 2;
            int count = method(lectures, mid);
            if (blueRay < count) {
                System.out.println("isOver!!");
                start = mid + 1;
            } else {
                System.out.println("Pass!!");
                result = mid;
                end = mid - 1;
            }
        }
        System.out.println("end = "+ result);
        return result;
    }

    public static int method(int[] lectures, int target) {
        int count = 0;
        int sum = 0;
        System.out.println("target = " + target);
        for (int i = 0; i < lectures.length; i++) {
            sum += lectures[i];
            if (target < sum) {
                count++;
                System.out.println("sum = "+ (sum - lectures[i]));
                sum = 0;
                i--;
                System.out.println("limit index = "+ (i+1));
            }
        }
        count++;
        System.out.println("count!!! -> " + count);
        return count;
    }

}
