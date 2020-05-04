package level2;

import java.util.HashSet;
import java.util.Set;

/*
문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 */
public class FindPrimeNumbers {
    //소수인지 체크한다.
    public boolean check(String now){
        int x = Integer.parseInt(now);
        if(x == 1 || x == 0) return false;
        int half = x/2;
        for(int i = 2 ; i <= half; i++){
            if(x%i == 0 || Math.sqrt(i) == x) return false;
        }
        return true;
    }
    //재귀함수를 이용해 모든 경우의 숫자를 찾는다.
    public void make(String numbers ,String now, int cnt,Set<Integer> set){
        //원하는 길이의 숫자를 만든 후 소수인지를 체크하여 set에 담는다.
        if(now.length() == cnt || numbers.equals("")) {
            if(check(now))set.add(Integer.parseInt(now));
            return ;
        }
        for (int i = 0; i < numbers.length(); i++) {
            String nextStr = numbers.replaceFirst(String.valueOf(numbers.charAt(i)),"");
            make(nextStr,now+numbers.charAt(i),cnt,set);
        }
    }
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= numbers.length(); i++) {
            make(numbers,"",i,set);
        }
        return set.size();
    }

    public static void main(String[] args) {
        FindPrimeNumbers findPrimeNumbers = new FindPrimeNumbers();
        System.out.println(findPrimeNumbers.solution("1234"));
    }
}
