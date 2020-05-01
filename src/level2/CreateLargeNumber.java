package level2;

/*
문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
 */

public class CreateLargeNumber {
    char[] chars;
    int max = 0;
    public void greedy(String prev, int end,int cnt){
        System.out.println(prev);
        if(prev.length() == end) {
            max = max < Integer.parseInt(prev) ? Integer.parseInt(prev) : max;
            return;
        }
        for (int i = cnt+1; i < chars.length; i++) {
            greedy(prev + chars[i],end,i);
        }
    }
    public String solution(String number, int k) {
        int btw = number.length() - k;
        chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            greedy("" + chars[i],btw,0);
        }
        return String.valueOf(max);
    }
    public static void main(String[] args) {
        CreateLargeNumber createLargeNumber = new CreateLargeNumber();
        System.out.println(createLargeNumber.solution("19245",3));
    }
}
