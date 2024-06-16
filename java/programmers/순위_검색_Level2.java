package programmers;

import java.util.Arrays;

public class 순위_검색_Level2 {
    public int[] solution(String[] info, String[] query) {
        Applicant[] apps = createApplicant(info);
        Arrays.sort(apps, (v1, v2) -> v1.number - v2.number);
        int[] answer = method(apps, query);
        return answer;
    }

    public int[] method(Applicant[] apps, String[] query) {
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int count = 0;
            String[] command = query[i].replaceAll(" ?and ?", " ").split(" ");
            int index = getStartIndex(apps, command);

            for (int j = index; j < apps.length; j++) {
                Applicant app = apps[j];
                if (app.correct(command)) {
                    count++;
                }
            }

            answer[i] = count;
        }
        return answer;
    }

    public int getStartIndex(Applicant[] apps, String[] command) {
        int number = Integer.parseInt(command[4]);

        int start = 0;
        int end = apps.length;
        int mid = 0;
        while (end > start) {
            mid = (start + end) / 2;
            Applicant app = apps[mid];
            if (app.isOver(number)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    public Applicant[] createApplicant(String[] info) {
        Applicant[] list = new Applicant[info.length];
        for (int i = 0; i < info.length; i++) {
            String str = info[i];
            String[] split = str.split(" ");
            Applicant app = new Applicant(split[0], split[1], split[2],
                    split[3], Integer.parseInt(split[4]));
            list[i] = app;
        }
        return list;
    }
}

class Applicant {
    String lang;
    String category;
    String level;
    String soulFood;
    int number;

    public Applicant(String lang, String category, String level,
                     String soulFood, int number){
        this.lang = lang;
        this.category = category;
        this.level = level;
        this.soulFood = soulFood;
        this.number = number;
    }

    public boolean correct(String[] command){
        if(!lang.contains(command[0]) && !command[0].equals("-")) return false;
        if(!category.contains(command[1]) && !command[1].equals("-")) return false;
        if(!level.contains(command[2]) && !command[2].equals("-")) return false;
        if(!soulFood.contains(command[3]) && !command[3].equals("-")) return false;
        return true;
    }

    public boolean isOver(int number){
        return number <= this.number;
    }

}

