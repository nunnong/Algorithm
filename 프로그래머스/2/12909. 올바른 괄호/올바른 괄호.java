import java.util.*;

class Solution {
    boolean solution(String s) {

        Deque<Character> dq = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                dq.push(c);
                continue;
            }
            
            if (dq.isEmpty()) {
                return false;
            } else {
                dq.pop();
            }
        }        

        return dq.isEmpty();
    }
}