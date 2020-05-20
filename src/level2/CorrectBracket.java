package level2;

public class CorrectBracket {
    boolean solution(String s) {
        if(s.charAt(0) != '(' || s.charAt(s.length()-1) != ')' || s.length() % 2 != 0) return false;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += s.charAt(i) == '(' ? 1 : -1;
            if(cnt < 0) return false;
        }
        return cnt == 0 ? true : false;
    }

    public static void main(String[] args) {
        CorrectBracket bracket = new CorrectBracket();
        System.out.println(bracket.solution("(()))(()"));
    }
}
