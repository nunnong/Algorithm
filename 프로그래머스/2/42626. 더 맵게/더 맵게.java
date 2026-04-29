import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int cnt = 0; // 계산 횟수를 의미
        
        while (pq.size() >= 2) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            
            if (min1 >= K) {
                return answer = cnt;
            }
            cnt++;
            pq.offer(min1 + min2 * 2);
        }
        
        if (pq.poll() >= K) {
            return answer = cnt;
        }
        
        
        return answer;
    }
}