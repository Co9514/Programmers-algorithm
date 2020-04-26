package level2;

import java.util.*;

/*
solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

제한 조건
bridge_length는 1 이상 10,000 이하입니다.
weight는 1 이상 10,000 이하입니다.
truck_weights의 길이는 1 이상 10,000 이하입니다.
모든 트럭의 무게는 1 이상 weight 이하입니다.
 */
public class TruckPassBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cnt = 0;
        int time[] = new int[truck_weights.length];
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ;;){
            answer ++;
            for(int j = 0; j < i ; j++){
                if (time[j] != 0)time[j] --;
            }
            if(i < truck_weights.length) {
                if (weight >= truck_weights[i]) {
                    time[i] = bridge_length-1;
                    queue.add(truck_weights[i]);
                    weight -= truck_weights[i];
                    i++;
                }
            }
            if(i == truck_weights.length && queue.isEmpty())break;
            if(cnt < time.length) {
                if (time[cnt] == 0) {
                    weight += queue.poll();
                    cnt++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        TruckPassBridge truckPassBridge = new TruckPassBridge();
        System.out.println(truckPassBridge.solution(2,10,new int[]{7,4,5,6}));
    }
}
