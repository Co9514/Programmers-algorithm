package level2;
/*
쇠막대기와 레이저의 배치를 표현한 문자열 arrangement가 매개변수로 주어질 때, 잘린 쇠막대기 조각의 총 개수를 return 하도록 solution 함수를 작성해주세요.

제한사항
arrangement의 길이는 최대 100,000입니다.
arrangement의 여는 괄호와 닫는 괄호는 항상 쌍을 이룹니다.
 */
public class IronBar {
    public int solution(String arrangement) {
        int answer = 0;
        int bar = 0;
        for(int i = 0 ; i < arrangement.length(); i++){
            if(arrangement.charAt(i) == '('){bar ++;continue;}
            else if(arrangement.charAt(i) == ')')bar--;
                if(arrangement.charAt(i-1) == '(')answer += bar;
                else answer ++;
            }
        return answer;
    }
    public static void main(String[] args) {
        IronBar ironBar = new IronBar();
        System.out.println(ironBar.solution("()(((()())(())()))(())"));
    }
}
