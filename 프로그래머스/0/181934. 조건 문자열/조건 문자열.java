class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        
        int diff = n - m;
        
        if (diff > 0 && ineq.equals(">")) {
            return 1;
        }
        
        if (diff == 0 && eq.equals("=")) {
            return 1;
        }
        
        if (diff < 0 && ineq.equals("<")) {
            return 1;
        }
        
        return 0;
    }
}