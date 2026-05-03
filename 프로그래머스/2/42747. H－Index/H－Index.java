import java.util.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();
        for (int c : citations) list.add(c);
        
        Collections.sort(list, Collections.reverseOrder());
        
        int indexH = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < i + 1) break;
            indexH = i + 1;
        }
        
        return indexH;
    }
}