package level1;

/*
https://programmers.co.kr/learn/courses/30/lessons/17681
*/

class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
      String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String a = "";
            String str1 = Integer.toBinaryString(arr1[i]);
            String str2 = Integer.toBinaryString(arr2[i]);
            str1 = "0".repeat(n-str1.length())+str1;
            str2 = "0".repeat(n-str2.length())+str2;
            for (int j = 0; j < n; j++) {
                if(str1.substring(0,1).equals("1") || str2.substring(0,1).equals("1") ){
                    a = a + "#";
                }else {a = a + " ";}
                str1 = str1.substring(1);
                str2 = str2.substring(1);
            }
            answer[i] = a;
        }
        return answer;
  }
}
