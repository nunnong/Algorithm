class Solution {
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] arr = new char[8];
    boolean[] used = new boolean[8];
    String[] conditions;
    int count = 0;

    public int solution(int n, String[] data) {
        conditions = data;
        permute(0);
        return count;
    }

    void permute(int depth) {
        if (depth == 8) {
            if (checkAll()) count++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!used[i]) {
                arr[depth] = friends[i];
                used[i] = true;
                permute(depth + 1);
                used[i] = false;
            }
        }
    }

    boolean checkAll() {
        for (String cond : conditions) {
            char a  = cond.charAt(0);
            char b  = cond.charAt(2);
            char op = cond.charAt(3);
            int  d  = cond.charAt(4) - '0';

            int posA = -1, posB = -1;
            for (int i = 0 ; i < 8 ; i++) {
                if (arr[i] == a) posA = i;
                if (arr[i] == b) posB = i;
            }
            
            // 실제 gap 계산 (사이에 있는 사람 수)
            int gap = Math.abs(posA - posB) - 1;

            switch (op) {
                case '=' : {
                    if (gap != d) return false;
                    break;
                }
                case '>' : {
                    if (gap <= d) return false;
                    break;
                }
                case '<' : {
                    if (gap >= d) return false;
                    break;
                }
            }            
        }
        return true;
    }
}