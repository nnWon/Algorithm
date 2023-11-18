package programmers;

public class 서울에서_김서방_찾기 {
    public String solution(String[] seoul) {
        int index = -1;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")){
                index = i;
                break;
            }
        }
        return "김서방은 "+index+"에 있다";
    }
}
