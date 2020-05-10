package level2;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

제한 사항
scoville의 길이는 2 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 */

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for ( int x : scoville) {
            queue.offer(x);
        }
        while (queue.peek() < K){
            if (queue.size() == 1) return -1;
            queue.offer(queue.poll() + (queue.poll()*2));
            answer ++;
        }
        return answer;
    }
    public static void main(String[] args) {
        MoreSpicy moreSpicy = new MoreSpicy();
        System.out.println(moreSpicy.solution(new int[]{1, 2, 13, 19, 10, 12},7));
    }
}
