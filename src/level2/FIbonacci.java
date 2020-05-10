package level2;

/*
2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

제한 사항
* n은 1이상, 100000이하인 자연수입니다.
 */
public class FIbonacci {
    public int solution(int n) {
        int before = 0;
        int now = 1;
        int cnt=1;
        while(cnt < n){
            int next = (before % 1234567) + (now  % 1234567);
            before = now;
            now = next;
            cnt ++;
        }
        return now % 1234567;
    }

    public static void main(String[] args) {
        FIbonacci fIbonacci = new FIbonacci();
        System.out.println(fIbonacci.solution(3));
    }
}
