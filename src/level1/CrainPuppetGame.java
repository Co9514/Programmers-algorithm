package level1;

import java.util.Stack;

/*
문제 설명
https://programmers.co.kr/learn/courses/30/lessons/64061
 */
public class CrainPuppetGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i< moves.length ; i ++){
            int next = 0;
            for(int j = 0 ; j < board.length; j++){
                if(0 < board[j][moves[i]-1]){
                    next = board[j][moves[i]-1];
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
            if(stack.empty() && next != 0) {
                stack.push(next);
            } else if(next != 0){
                if (stack.peek() == next){
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(next);
                }
            }
        }
        return answer;
    }
}
