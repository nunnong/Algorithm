import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        dfs("");
        return list.indexOf(word) + 1;
    }

    static void dfs(String cur) {
        if (cur.length() == 5) return;

        for (char c : vowels) {
            String next = cur + c;
            list.add(next);
            dfs(next);
        }
    }
}