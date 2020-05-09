package level2;

import java.util.ArrayList;
import java.util.List;

/*
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

제한 사항
phone_book의 길이는 1 이상 1,000,000 이하입니다.
각 전화번호의 길이는 1 이상 20 이하입니다.
 */
public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> list = new ArrayList<>();
        for (String str : phone_book) {
            list.add(str);
        }
        for (int i = 0; i < list.size(); i++) {
            for (String str : phone_book) {
                if(list.get(i).equalsIgnoreCase(str)) continue;
                if (list.get(i).startsWith(str)) return false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PhoneNumberList phoneNumberList = new PhoneNumberList();
        System.out.println(phoneNumberList.solution(new String[]{"12","45","412"}));
    }
}
