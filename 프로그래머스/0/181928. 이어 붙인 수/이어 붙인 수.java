class Solution {
    public int solution(int[] num_list) {
        
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        
        for (int i : num_list) {
            if (i % 2 == 1) {
                odd.append(i);
            } else {
                even.append(i);
            }
        }
        
        int answer = Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());
        
        return answer;
    }
}