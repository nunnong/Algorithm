import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {

        boolean hasTarget = false;
        
        for (String w : words) {
            if (w.equals(target)) { 
                hasTarget = true; 
                break; 
            }
        }
        if (!hasTarget) return 0;

        // BFS
        Queue<String> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(begin);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                for (int j = 0; j < words.length; j++) {
                    if (visited[j]) continue;
                    if (isConvertible(curr, words[j])) {
                        if (words[j].equals(target)) return depth;
                        visited[j] = true;
                        queue.offer(words[j]);
                    }
                }
            }
        }

        return 0;
    }

    private boolean isConvertible(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
}