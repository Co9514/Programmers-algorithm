package level2;

import java.util.ArrayDeque;
import java.util.Queue;

/*문제 설명
1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
ex) 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
제한사항
1. 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
2. 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
3. location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
*/
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue queue = new ArrayDeque();
        //큐를 생성해 담아준다.
        for(int x : priorities){
            queue.add(x);
        }
        //큐에서 가장 큰 우선순위 값
        int max = max(queue);
        //해당하는 인쇄물이 나올때까지 돌도록 한다.
        while(location >= 0){
            //가장 먼저 나오는 큐에 값
            int next = (int) queue.peek();
            //다음에 나오는 큐에 값이 가장 큰 우선순위라면 원하는 인쇄물의 인덱스 위치와 비교하여 원하는 인쇄물일 경우
            //루프를 빠져나오도록 한다.
            if(next == max){
                if(location == 0){break;}
                //원하는 인쇄물이 아니므로 우선순위 인쇄물을 일단 인쇄하여 큐에서 삭제
                queue.remove();
                //원하는 인쇄물의 인덱스를 줄인다.
                location --;
                //카운트 증가
                answer ++;
                //새로 가장 큰 우선순위 값을 할당해준다.
                max = max(queue);
            }else if(next < max){
                //다음 큐에 담긴 값이 가장 큰 값보다 작으므로 뒤로 넘긴다.
                // 만약 원하는 인쇄물이였다면 맨 뒤로 가야하므로 인덱스 값을 큐의 전체 크기의 -1을 담아준다.
                if(location == 0 ) {location = queue.size()-1;}
                else {location --;}
                queue.offer(queue.poll());
            }
        }
        return answer;
    }
    private int max(Queue<Integer> queue){
        int max = 0;
        for (int i : queue) {
            if(i > max)max = i;
        }
        return max;
    }
}
public class Printer {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1, 1, 9, 1, 1, 1},0));
    }
}
