class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for (int i = 0 ; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if (w < h) {
                int tmp = w;
                w = h;
                h = tmp;
            }
            
            maxW = (maxW < w) ? w : maxW;
            maxH = (maxH < h) ? h : maxH;
        }
        
        
        
        return maxW * maxH;
    }
}