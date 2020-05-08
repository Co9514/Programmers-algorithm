package level2;

/*
2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

제한 사항
* n은 1이상, 100000이하인 자연수입니다.
 */
public class FIbonacci {
    int answer = 0;
    public void fibonacci(int before ,int now ,int cnt, int n){
        if (cnt == n) {
            answer = now % 1234567;
            return;
        }
        int next = (before % 1234567) + (now  % 1234567);
        fibonacci(now, next, cnt+1, n);
    }
    public int solution(int n) {
        fibonacci(0,1,1,n);
        return answer;
    }

    public static void main(String[] args) {
        FIbonacci fIbonacci = new FIbonacci();
        System.out.println(fIbonacci.solution(3));
    }
}
