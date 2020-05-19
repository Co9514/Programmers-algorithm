import java.util.ArrayList;
class Mockexam {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length]) score[0]++;
            if (answers[i] == person2[i % person2.length]) score[1]++;
            if (answers[i] == person3[i % person3.length]) score[2]++;
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (max == score[0]) list.add(1);
        if (max == score[1]) list.add(2);
        if (max == score[2]) list.add(3);

        int[] answer = new int[list.size()];
        for (int i = 0 ; i < answer.length ; i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}
