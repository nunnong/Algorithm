import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<int[]> stack = new ArrayDeque<>();
        
        int maxTime = prices.length;
        int currTime = 1;
        stack.push(new int[]{0, currTime});
        currTime++;
        
        for (int i = 1 ; i < prices.length; i++) {
            int[] peek = stack.peek();
            
            if (prices[peek[0]] <= prices[i]) {
                stack.push(new int[]{i, currTime});
                currTime++;
                continue;
            }
            
            while (!stack.isEmpty() && prices[peek[0]] > prices[i]) { // stack 최상위 price > 넣으려는 price 
                answer[peek[0]] = currTime - peek[1];
                stack.pop();
                peek = stack.peek();
            }
            stack.push(new int[]{i, currTime});
            currTime++;
        }
        
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            answer[curr[0]] = maxTime - curr[1];
        }
        
        return answer;
    }
}