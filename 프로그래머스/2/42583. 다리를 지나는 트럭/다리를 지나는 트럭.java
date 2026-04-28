import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> q = new ArrayDeque<>(); // [트럭무게, 내려갈 시간]
        int time = 0;
        int sum = 0;
        int truckIdx = 0;
        
        while (truckIdx < truck_weights.length || !q.isEmpty()) {
            time++;
            
            // 1. 내려갈 트럭 있으면 내리기
            if (!q.isEmpty() && q.peek()[1] == time) {
                sum -= q.poll()[0];
            }
            
            // 2. 다음 트럭 올릴 수 있으면 올리기
            if (truckIdx < truck_weights.length 
                && sum + truck_weights[truckIdx] <= weight) {
                sum += truck_weights[truckIdx];
                q.offer(new int[]{truck_weights[truckIdx], time + bridge_length});
                truckIdx++;
            }
        }
        
        return time;
    }
}