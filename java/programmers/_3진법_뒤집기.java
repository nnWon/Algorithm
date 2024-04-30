package programmers;

public class _3진법_뒤집기 {
    public int solution(int n) {
        String nToString = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder(nToString).reverse();
        return Integer.parseInt(sb.toString(), 3);
    }
}
