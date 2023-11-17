package programmers;

class 최댓값과_최솟값 {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String str : s.split(" ")) {
            int num = Integer.parseInt(str);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min + " " + max;
    }
}