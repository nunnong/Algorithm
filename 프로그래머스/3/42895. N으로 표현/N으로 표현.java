import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        int answer = -1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        for (int i = 0 ; i <= 8 ; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        
        for (int i = 2 ; i <= 8 ; i++) {
            int concat = 0;
                
            for (int k = 0 ; k < i ; k++) {
                concat = concat * 10 + N;
            }
            
            dp.get(i).add(concat);
            
            for (int j = 1 ; j < i ; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i-j)){
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        
                        if (b != 0) dp.get(i).add(a / b);
                    };
                }
            }
        }
        
        for (int i = 1 ; i <= 8 ; i++) {
            if (dp.get(i).contains(number)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}