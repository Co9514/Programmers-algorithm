package level1;
/*
문제 설명
정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

제한 조건
arr은 길이 1 이상인 배열입니다.
인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
*/

class RemoveSmallNum {
  public int[] solution(int[] n) {
      if(n.length == 1)return new int[]{-1};
        int min = n[0];
        int cnt = 1;
        for (int i = 1; i < n.length; i++) {
            if(min > n[i]) {
                cnt = 1;
                min = n[i];
            }else if(min == n[i]){
                cnt ++;
            }
        }
        if(cnt == n.length)return new int[]{-1};
        int[] answer = new int[n.length - cnt];
        cnt = 0;
        for(int i = 0 ; i < n.length; i++){
            if(n[i] != min) {
                answer[cnt] = n[i];
                cnt ++;
            }
        }
        return answer;
  }
}
