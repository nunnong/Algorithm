import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        // 명령어를 돌아가면서 실행 (명령어 길이만큼)
        for (int i = 0 ; i < commands.length ; i++) {
            
            int start = commands[i][0] - 1;
            int end = commands[i][1] -1;
            int ans = commands[i][2] -1;
            
            int[] arr = Arrays.copyOfRange(array, start, end+1);
            Arrays.sort(arr);
            answer[i] = arr[ans];
        }
        
        return answer;
    }
}