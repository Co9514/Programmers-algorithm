package level2;

/*
문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
 */

public class CreateLargeNumber {
    public String solution(String number, int k) {
        //StringBuilder를 이용해 + 연산을 계속 하지 않고 마지막에 하나의 문자열로 그냥 만들어서 리턴하기 위함.
        //String에 문자열을 더할 경우 새로 문자를 더한 뒤 그 객체를 담기 떄문에 연산이 느려짐.
        StringBuilder sb = new StringBuilder();

        //추가해야 될 숫자의 개수
        int cnt = number.length() - k;
        //좌측 인덱스
        int left = 0;
        //좌측이 갈 수 있는 최대 인덱스
        int right = number.length() - cnt;
        // 가장 큰 값을 담을 변수
        int max = -1;
        //비교를 시작하는 인덱스의 위치
        int idx = 0;

        while(cnt > 0) {
            max = -1;
            //좌측 인덱스부터 우측으로 갈 수 있는 최대의 인덱스 위치까지 for문을 돌며 루프를 실행한다.
            //                              코드를 실행할 때에는 j + 1 의 값을 이용하기 위해 ++j
            for(int j = left ; j <= right ; ++j){
                //int 값으로 비교하기 위해 비교할 인덱스의 문자에 -'0'을 해준다.
                int num = number.charAt(j) - '0';
                //비교를 하여 더 큰 값을 max로 넣는다.
                if(num > max){
                    idx = j;
                    max = num;
                }
            }
            //나온 값을 stringbuilder에 append
            sb.append(number.charAt(idx));
            //시작할 왼쪽 인덱스의 값을 idx 이후로 넣기 위해.
            left = idx + 1;
            //우측으로 갈 수 있는 최대의 값을 수정
            right = number.length() - --cnt;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        CreateLargeNumber createLargeNumber = new CreateLargeNumber();
        System.out.println(createLargeNumber.solution("1215841231365",5));
    }
}
