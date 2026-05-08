class Solution {
    public int[] solution(int brown, int yellow) {
        
        for (int height = 1; height * height <= yellow; height++) {
            
            if (yellow % height != 0) continue;
            int width = yellow / height;

            if ((width + height) * 2 + 4 == brown) {
                return new int[]{width + 2, height + 2};
            }
        }
        return new int[]{};
    }
}