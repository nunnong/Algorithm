import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int col = 1 ; col <= Math.sqrt(yellow) ; col++) { // col <= row
            if (yellow % col != 0) continue;
            int row = yellow / col;
            
            if (calBrown(row, col, brown)){
                answer[0] = row + 2;
                answer[1] = col + 2;
            }
        }
        return answer;
    }
    
    public boolean calBrown(int r, int c, int brown) {
        int value = (r + c) * 2 + 4;
        if (value == brown) return true;
        
        return false;
    }
    
}