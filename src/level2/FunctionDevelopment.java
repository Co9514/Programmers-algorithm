package level2;

import java.util.ArrayList;

/*
문제 설명
프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

제한 사항
작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
작업 진도는 100 미만의 자연수입니다.
작업 속도는 100 이하의 자연수입니다.
배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 */
public class FunctionDevelopment {
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            ArrayList<Integer> list = new ArrayList<>();
            //총 작업해야하는 양만큼의 for문을 선언
            for(int i = 0 ; i < progresses.length;){
                //현재 i번째의 작업이 100프로가 될때까지 루프를 돌아준다.
                while(progresses[i] <= 100){
                    //모든 작업들에 대해서 speed만큼 증가시킨다.
                    for(int j = i ; j < progresses.length; j ++){
                        //100이 넘은 경우 쓸모없는 연산을 줄이기 위해 조건문을 넣어주었다.
                        if(progresses[j] <= 100){progresses[j] += speeds[j];}
                    }
                }
                int cnt = 0;
                //while문을 빠져나온 시점에서 i번째의 작업이 100프로가 되었으며 그 뒤로 몇개의 작업이 100프로인지 체크한다.
                for(int o = i ; o < progresses.length ; o++){
                    if(progresses[o] >= 100) {
                        cnt++;
                        //100프로가 된 갯수가 있는 만큼 i를 증가시킨다.
                        i++;
                    }
                    else break;
                }
                list.add(cnt);
            }
            int[] answer = new int[list.size()];
            //ArrayList를 int 배열로 변환한다.
            for(int i = 0 ; i <list.size();i++){
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new FunctionDevelopment.Solution();
        System.out.println(solution.solution(new int[]{93,30,55},new int[]{1,30,5}));
    }
}