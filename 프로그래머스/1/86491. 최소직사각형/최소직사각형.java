class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for (int i = 0 ; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            maxW = Math.max(maxW, Math.max(w, h));
            maxH = Math.max(maxH, Math.min(w, h));
        }
        
        return maxW * maxH;
    }
}