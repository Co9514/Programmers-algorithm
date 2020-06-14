package level1;
/*
문제 설명
정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

제한 사항
n은 0 이상 3000이하인 정수입니다.
*/
import java.util.HashSet;
import java.util.Iterator;
class SumDivisor {
  public int solution(int n) {
      if(n == 2){return 3;}
      if(n == 1){return 1;}
      HashSet<Integer> set = new HashSet<>();
        for(int x = 1; x <= n/2 ; x++){
            if(n%x == 0){
                set.add(x);
                set.add(n/x);
            }
        }
        int sum = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            sum += iterator.next();
        }
        return sum;
  }
}
