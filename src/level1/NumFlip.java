package level1;
/*
문제 설명
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.
*/
import java.util.ArrayList;
class NumFlip {
  public int[] solution(long n) {
      ArrayList<Integer> arr = new ArrayList<>();
        while(true){
            arr.add((int) (n % 10));
            n = n/10;
            if(n <= 0){
                break;
            }
        }
        int[] answer = new int[arr.size()] ;
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
  }
}
