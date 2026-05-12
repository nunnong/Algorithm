import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int n = number.length();
        int remainCount = n - k;
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = number.charAt(i) - '0';
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;

        for (int i = 0; i < remainCount; i++) {
            int max = -1, maxIdx = start;

            for (int j = start; j <= k + i; j++) {
                if (numbers[j] > max) {
                    max = numbers[j];
                    maxIdx = j;
                }
            }

            sb.append(max);
            start = maxIdx + 1;
        }

        return sb.toString();
    }
}