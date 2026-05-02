import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = 0;
        
        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (cmd.equals("I")) {
                map.merge(num, 1, Integer::sum);
                size++;
            } else if (size > 0) {
                int key = (num == 1) ? map.lastKey() : map.firstKey();
                if (map.get(key) == 1) map.remove(key);
                else map.put(key, map.get(key) - 1);
                size--;
            }
        }
        
        if (size == 0) return new int[]{0, 0};
        return new int[]{map.lastKey(), map.firstKey()};
    }
}