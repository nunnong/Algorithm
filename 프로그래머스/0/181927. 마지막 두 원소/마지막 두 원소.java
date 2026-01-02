import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        
        int[] answer = Arrays.copyOf(num_list, num_list.length + 1);

        int num1 = num_list[num_list.length - 1];
        int num2 = num_list[num_list.length - 2];

        answer[num_list.length] = (num1 > num2) ? (num1 - num2) : (num1 * 2);
        
        
        return answer;

    }
}