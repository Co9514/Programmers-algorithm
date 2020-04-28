package level2;

import java.util.ArrayDeque;
import java.util.Queue;

/*
압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라
압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

제한사항
s의 길이는 1 이상 1,000 이하입니다.
s는 알파벳 소문자로만 이루어져 있습니다.
 */
public class StringCompression {
    String ax ;
    Queue<String> queue = new ArrayDeque();

    public void Compression(Queue<String> queue,int cnt){
        if(queue.isEmpty()) return ;
        String now = queue.poll();
        String next = queue.peek();
        if(!now.equals(next)){
            if(cnt > 1)  ax = ax + cnt + now;
            else ax = ax + now;
            Compression(queue,1);
        }
        else Compression(queue,++cnt);
    }

    public int solution(String s) {
        int answer = s.length();
        int len = s.length()/2;
        for(int i = 1 ; i <= len; i++){
            ax = "";
            String t = s;
            // Queue에 값을 넣어준다.
           while (t.length() > 0){
               if(t.length() < i ) {
                   queue.add(t);
                   break;
               }
               else{queue.add(t.substring(0,i));}
               t = t.substring(i);
           }
           //재귀함수를 통한 압축
           Compression(queue,1);
           //압축된 크기가 작은 것을 정답으로
           if(answer > ax.length()) answer = ax.length();
        }
        return answer;
    }
    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.solution("abcabcabcabcdededededede"));
    }
}
