package level2;

import java.util.*;
/*
입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.

제한조건
1. 1 <= m, n <= 100
2. picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
3. picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
 */

public class ColoringBook {
        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};
        static int[][] picture;
        static boolean[][] visited;

        public int[] solution(int m, int n, int[][] picture) {
            this.picture = picture;
            visited = new boolean[m][n];
            int[] answer = bfs(m, n);
            return answer;
        }
        static int[] bfs(int m, int n) {
            int[] answer = new int[2];
            Stack<Integer> sx = new Stack<>();
            Stack<Integer> sy = new Stack<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int count = 0;
                    if (picture[i][j] != 0 && !visited[i][j]) {
                        addComponent(sx, sy, i, j);
                        count++;
                        answer[0]++;
                    }

                    while(!sx.isEmpty()) {
                        int x = sx.pop();
                        int y = sy.pop();

                        if (x > 0 && picture[x-1][y]== picture[i][j] && !visited[x-1][y]) {
                            addComponent(sx, sy, x-1, y);
                            count++;
                        }

                        if (y > 0 && picture[x][y-1]== picture[i][j] && !visited[x][y-1]) {
                            addComponent(sx, sy, x, y-1);
                            count++;
                        }

                        if (x < m-1 && picture[x+1][y]== picture[i][j] && !visited[x+1][y]) {
                            addComponent(sx, sy, x+1, y);
                            count++;
                        }

                        if (y < n-1 && picture[x][y+1]== picture[i][j] && !visited[x][y+1]) {
                            addComponent(sx, sy, x, y+1);
                            count++;
                        }
                    }
                    answer[1] = Math.max(count, answer[1]);
                }
            }
            return answer;
        }
        static void addComponent(Stack<Integer> sx, Stack<Integer> sy, int x, int y) {
            sx.add(x);
            sy.add(y);
            visited[x][y] = true;
        }
    public static void main(String[] args) {
        ColoringBook coloringBook = new ColoringBook();
        System.out.println(Arrays.toString(coloringBook.solution(6,4,new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}})));
    }
}
