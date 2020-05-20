package level2;

/*
문제 설명
1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)

제한사항
표(board)는 2차원 배열로 주어집니다.
표(board)의 행(row)의 크기 : 1,000 이하의 자연수
표(board)의 열(column)의 크기 : 1,000 이하의 자연수
표(board)의 값은 1또는 0으로만 이루어져 있습니다.
 */

public class BiggestSquare {
    public int solution(int [][]board) {
        int answer = 0;
        if(board.length > 1 && board[0].length > 1){
            for (int i = 1; i < board.length; i++) {
                for (int j = 1; j < board[0].length; j++) {
                    if (board[i][j] == 1){
                        int min = Math.min(board[i][j - 1],board[i - 1][j]);
                        board[i][j] = Math.min(min,board[i - 1][j - 1]) + 1;
                    }
                }
            }
        }
        for (int[] x : board) {
            for (int y : x) {
                answer = Math.max(answer,y);
            }
        }
        return (int)Math.pow(answer,2);
    }

    public static void main(String[] args) {
        BiggestSquare square = new BiggestSquare();
        System.out.println(square.solution(new int[][]{{0,1,1,1,1,0,1,1},{0,1,1,1,1,0,1,1},{0,1,1,1,1,0,1,1},{0,1,1,1,1,0,1,1}}));
    }
}
