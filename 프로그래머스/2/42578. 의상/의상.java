import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0 ; i < clothes.length ; i++) {
            String s = clothes[i][1];
            map.put(s, map.getOrDefault(s,0)+1);
        }
        
        for (int i : map.values()) {
            answer *= (i+1);
        }
        
        return answer - 1;
    }
}