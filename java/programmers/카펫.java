package programmers;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int totalSize = brown + yellow;

        for (int h = 3; h <= totalSize / h; h++) {
            if (totalSize % h != 0) {
                continue;
            }
            int w = totalSize / h;
            int border = (w - 1) * 2 + (h - 1) * 2;
            if (border == brown) {
                return new int[]{w, h};
            }
        }
        return new int[]{0};
    }
}
