class Solution {
    public int solution(int a, int b) {
        
        int ab = Integer.parseInt(a + "" + b);
        int ba = Integer.parseInt(b + "" + a);
        
        int answer = (ab >= ba) ? ab : ba;
        
        return answer;
    }
}