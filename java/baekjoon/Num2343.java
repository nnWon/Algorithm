package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] lectures = new int[n];
        int sum = 0;
        int longLecture = 0;
        for (int i = 0; i < n; i++) {
            int lecture = Integer.parseInt(st.nextToken());
            lectures[i] = lecture;
            sum += lecture;
            longLecture = Math.max(longLecture, lecture);
        }

        System.out.println(binarySearch(longLecture, sum, m, lectures));
    }

    public static int binarySearch(int min, int max, int blueRay, int[] lectures) {
        int start = min;
        int end = max;
        int result = 0;
        while (end >= start) {
            int mid = (start + end) / 2;
            int count = method(lectures, mid);
            if (blueRay < count) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        return result;
    }

    public static int method(int[] lectures, int target) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < lectures.length; i++) {
            sum += lectures[i];
            if (target < sum) {
                count++;
                sum = 0;
                i--;
            }
        }
        count++;
        return count;
    }

}
