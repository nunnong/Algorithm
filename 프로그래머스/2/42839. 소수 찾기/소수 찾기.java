import java.util.*;

class Solution {
    static Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {
        char[] num = numbers.toCharArray();
        boolean[] visited = new boolean[num.length];
        
        for (int i = 1; i <= num.length; i++) {
            permutation(num, visited, "", i);
        }
        return primes.size();
    }
    
    static void permutation(char[] num, boolean[] visited, String current, int target) {
        if (current.length() == target) {
            int n = Integer.parseInt(current);
            if (isPrime(n)) primes.add(n);
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(num, visited, current + num[i], target);
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}