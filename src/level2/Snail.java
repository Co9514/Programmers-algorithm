package level2;

/*
문제 설명
정수 n이 매개변수로 주어집니다.
다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 */

public class Snail {
    static int[] answer;
    static int value;
    static int N;

    public int[] solution(int n) {
        N = n;
        answer = new int[n * (n + 1) / 2];
        value = 1;
        int k = 0;
        while (n >= 1) {
            fillArr(2 * k * (k + 1), 2 * k + 1, n, k);
            n -= 3;
            k++;
        }
        return answer;
    }

    private void fillArr(int startIdx, int sub, int n, int k) {
        if (n == 1) {
            answer[startIdx] = value;
            return;
        }
        // / 왼쪽 대각선
        int idx = startIdx;
        int cnt = n - 1; // 밑변을 제외한 횟수
        while (cnt > 0) {
            answer[idx] = value++;
            idx += sub++;
            cnt--;
        }
        // ㅡ 밑변
        for (int i = 0; i < n; i++) {
            answer[idx++] = value++;
        }
        // \ 오른쪽 대각선
        idx--;
        int nk = N - k;
        for (int i = 0; i < n - 2; i++) {
            idx -= nk;
            answer[idx] = value++;
            nk--;
        }
    }

    public static void main(String[] args) {
        Snail snail = new Snail();
        System.out.println(snail.solution(5));
    }
}
