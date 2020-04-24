package level2;

/*
가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.

제한사항
W, H : 1억 이하의 자연수
 */

public class FineSquare {
    public long solution(int w,int h) {
        long temp = 1 ;
        long a ,b ;
        if(w > h ) {a = w ; b = h;}
        else {a = h ; b = w;}
        //최대 공약수를 구한다.
        while(temp != 0){
            temp = b%a;
            b = a;
            a = temp;
        }
        long answer = ((long)w*(long)h)-(((long)w+(long)h)-b);
        return answer;
    }
    public static void main(String[] args) {
        FineSquare fineSquare = new FineSquare();
        System.out.println(fineSquare.solution(84511231,154154));
    }
}
