package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Num1076 {

    static String[] COLORS = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    static Map<String, Integer> VALUES = new HashMap<>();
    static Map<String, Integer> MULTIPLY = new HashMap<>();

    private static void initValuesAndMultiply() {

        for (int i = 0; i < COLORS.length; i++) {
            VALUES.put(COLORS[i], i);
            MULTIPLY.put(COLORS[i], (int) Math.pow(10, i));
        }
    }

    public static void main(String[] args) throws IOException {
        initValuesAndMultiply();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();
        long result = (long)(VALUES.get(color1) * 10 + VALUES.get(color2)) * MULTIPLY.get(color3);
        System.out.println(result);
    }
}
