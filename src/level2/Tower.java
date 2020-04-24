package level2;

import java.util.Arrays;

/*
맨 왼쪽부터 순서대로 탑의 높이를 담은 배열 heights가 매개변수로 주어질 때 각 탑이 쏜 신호를 어느 탑에서 받았는지 기록한 배열을
return 하도록 solution 함수를 작성해주세요.

제한 사항
heights는 길이 2 이상 100 이하인 정수 배열입니다.
모든 탑의 높이는 1 이상 100 이하입니다.
신호를 수신하는 탑이 없으면 0으로 표시합니다.
 */
public class Tower {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        answer[0] = 0;
        for(int i = heights.length-1 ; i > 0 ; i--){
            for(int j = i-1 ; j >= 0 ; j--){
                if(heights[i] < heights[j]) {answer[i] = j+1; break;}
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Tower tower = new Tower();
        System.out.println(tower.solution(new int[]{6,9,5,7,4}));
    }
}
