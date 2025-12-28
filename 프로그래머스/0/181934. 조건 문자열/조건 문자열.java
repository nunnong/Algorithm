class Solution {
    public int solution(String ineq, String eq, int n, int m) {

        if (ineq.equals(">") && eq.equals("=")) return n >= m ? 1 : 0;
        if (ineq.equals("<") && eq.equals("=")) return n <= m ? 1 : 0;
        if (ineq.equals(">") && eq.equals("!")) return n > m ? 1 : 0;
        if (ineq.equals("<") && eq.equals("!")) return n < m ? 1 : 0;

        return 0;
    }
}
