package level2;
/*
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.
 */
public class Joystick {
    public int solution(String name) {
        int answer = 0;
        char[] chars = name.toCharArray();
        int top = 0 ;
        int a = 0;
        for (int i = 0; i < chars.length; i++) {
            //가장 조이스틱 커서에서 가장 가까운 방향으로 조이스틱 이동횟수
            if(i != 0 && i - top > ((top % chars.length)+(chars.length - i)) && chars[i] != 'A') {
                answer += (top % chars.length)+(chars.length - i);
                top = i;
            } else if(i != 0 && chars[i] != 'A'){
                answer += i - top;
                top = i;
            }
            int x = (int)chars[i] % 65;
            // 가까운 알파벳 방향으로 조이스틱 이동횟수
            if(x > 13) answer += 26 - x;
            else answer += x;
        }
        return answer;
    }
    public static void main(String[] args) {
        Joystick joystick = new Joystick();
        System.out.println(joystick.solution("JABAAAAAAAAB"));
    }
}
