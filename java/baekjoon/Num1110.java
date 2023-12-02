package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int number = target;
        int cycle = 1;
        while (true){
            number = createNewNumber(number);
            if (number == target) break;
            cycle++;
        }
        System.out.println(cycle);
    }

    private static int createNewNumber(int number) {
        int left = number / 10;
        int right = number % 10;
        int newRight = (left + right) % 10;
        return right * 10 + newRight;
    }
}
