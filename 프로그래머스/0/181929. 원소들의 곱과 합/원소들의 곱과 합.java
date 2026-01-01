class Solution {
    public int solution(int[] num_list) {
        
        int mul = 1;
        int add = 0;
        
        for (int num : num_list) {
            mul *= num;
            add += num;
        }
        
        int answer = (add * add > mul) ? 1 : 0;
        return answer;
    }
}