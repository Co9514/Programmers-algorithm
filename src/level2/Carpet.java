package level2;

/*
Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.

Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 */

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int x = 3;
        int[] answer = new int[2];
        while(true){
            if(sum % x == 0){
                int y = sum / x;
                if((x-2)*(y-2) == yellow) {
                    answer[0] = Math.max(x,y);
                    answer[1] = Math.min(x,y);
                    return answer;
                }
            }
            x++;
        }
        // 다른 사람의 풀이 중 인상 깊은 것이 있어서 남겨봅니다.
        // 어떻게 이렇게 풀 생각을 하는지 감탄...
//        int a = (brown+4)/2;
//        int b = yellow+2*a-4;
//        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        //return answer;
    }
    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        System.out.println(carpet.solution(24,24));
    }
}
