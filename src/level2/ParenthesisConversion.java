package level2;
/*
1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
  4-3. ')'를 다시 붙입니다.
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
  4-5. 생성된 문자열을 반환합니다.
균형잡힌 괄호 문자열 p가 매개변수로 주어질 때, 주어진 알고리즘을 수행해 올바른 괄호 문자열로 변환한 결과를 return 하도록 solution 함수를 완성해 주세요.

매개변수 설명
p는 '(' 와 ')' 로만 이루어진 문자열이며 길이는 2 이상 1,000 이하인 짝수입니다.
문자열 p를 이루는 '(' 와 ')' 의 개수는 항상 같습니다.
만약 p가 이미 올바른 괄호 문자열이라면 그대로 return 하면 됩니다.
 */
public class ParenthesisConversion {
    //올바른 괄호인지 체크
    public boolean check(String p){
        int check = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') check++;
            else check--;
            if(check < 0) return false;
        }
        return true;
    }
    //u와 v를 나누기 위한 index를 찾는 함수
    public int uv(String uv){
        int cnt = 0;
        int i = 1;
        if (uv.charAt(0) == '(') cnt++;
        else cnt--;
        while (i < uv.length()){
            if (uv.charAt(i) == '(') cnt++;
            else cnt--;
            if(cnt == 0) break;
            i++;
        }
        return i;
    }
    //정렬해주는 재귀함수
    public String change(String u){
        if(u.equals("")) return u;
        String change = "";
        String u2 = u.substring(0, uv(u) + 1);
        String v = u.substring(uv(u) + 1);
        if(check(u2)) {
            u2 += change(v);
            return u2;
        }
        else change += '(' + change(v) + ')';
        for (int i = 1; i < u2.length() - 1; i++) {
            change += u2.charAt(i) == '(' ? ")" : "(";
        }
        return change;
    }
    public String solution(String p) {
        if(check(p)) return p;
        return change(p);
    }

    public static void main(String[] args) {
        ParenthesisConversion parenthesisConversion = new ParenthesisConversion();
        System.out.println(parenthesisConversion.solution(")()()()()("));
    }
}
