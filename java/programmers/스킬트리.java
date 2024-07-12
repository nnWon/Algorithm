package programmers;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {

        String regex = "[^" + skill + "]";

        int count = 0;
        for (String str : skill_trees) {
            String nStr = str.replaceAll(regex, "");
            if (isCorrectOrder(nStr, skill)) {
                count++;
            }
        }
        return count;
    }

    public boolean isCorrectOrder(String str, String skill) {

        for (int i = 0; i < str.length(); i++) {
            int order = skill.indexOf(str.charAt(i));
            if (i != order) {
                return false;
            }
        }
        return true;
    }
}
