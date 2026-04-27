import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int idx = curr[0];
            int priority = curr[1];
            
            boolean hasHigher = false;
            for (int p : priorities) {
                if (p > priority) {
                    hasHigher = true;
                    break;
                }
            }
            
            if (hasHigher) {
                queue.offer(curr);
            } else {
                answer++;
                priorities[idx] = 0;
                if (idx == location) return answer;
            }
        }
        return answer;
    }
}