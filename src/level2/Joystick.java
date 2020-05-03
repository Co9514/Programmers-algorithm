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
        // 가까운 알파벳 방향으로 조이스틱 이동횟수
        for (int i = 0; i < chars.length; i++) {
            int x = (int)chars[i] % 65;
            answer += x > 13 ? 26 - x : x;
        }

        int minMove = name.length() - 1;

        //모든 인덱스들에서 'A'가 아닌 곳에서 좌우중 가장 가까운 곳을 찾는다.
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i) != 'A') {
                int next = i+1;
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                // 현재 index 에 2를 곱한 후 전체 길이를 더해준 뒤에 'A'가 아닌 다음 인덱스의 길이만큼을 빼준다.
                // 모든 인덱스 중 가장 짧은 수가 MIN
                int move = 2 * i + name.length() - next;
                minMove = Math.min(move, minMove);
            }
        }

        return answer + minMove;
    }
    public static void main(String[] args) {
        Joystick joystick = new Joystick();
        System.out.println(joystick.solution("ABAAAAAAAAAAAAAAAAAAABBBB"));
    }
}
