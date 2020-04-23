package level2;

/*
자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
제한사항
n은 500,000,000이하의 자연수 입니다.
 */

public class NumberOf124Countries {
    public String solution(int n) {
        String answer = "";
        while(n != 0){
            int x = n % 3 ;
            n = n / 3;
            if( x == 0 ){ answer = 4 + answer; n--;}
            else answer = x + answer ;
        }
        return answer;
    }
    public static void main(String[] args) {
        NumberOf124Countries numberOf124Countries = new NumberOf124Countries();
        System.out.println(numberOf124Countries.solution(9));
    }
}
