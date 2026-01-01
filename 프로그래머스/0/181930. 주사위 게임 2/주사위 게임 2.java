class Solution {
    public int solution(int a, int b, int c) {
        
        int[] dice = new int[7];
        
        dice[a]++;
        dice[b]++;
        dice[c]++;
        
        int max = 1;
        
        for (int i = 1 ; i <= 6 ; i++) {
            if (max < dice[i]) {
                max = dice[i];
            }
        }
        
        int answer = 0;
        
        switch(max) {
            case 1 :
                answer = a + b + c;
                break;
                
            case 2 :
                answer = (a + b + c) * (a * a + b * b + c * c);
                break;
                            
            case 3 :
                answer = a * 3 * a * a * 3 * a * a * a * 3;
                break;
        }
        return answer;
    }
}