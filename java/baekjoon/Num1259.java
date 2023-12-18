package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while (!str.equals("0")){
            StringBuffer reverse = new StringBuffer(str).reverse();
            if (reverse.toString().equals(str)) {
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
            str = br.readLine();
        }
    }
}
