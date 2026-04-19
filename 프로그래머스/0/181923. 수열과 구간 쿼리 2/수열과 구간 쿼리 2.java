class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        int[] answer = new int[queries.length];
        
        
        for (int i = 0 ; i < queries.length; i++) {
            int value = 1000001;
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            
            for (int j = s ; j <= e ; j++) {
                if (arr[j] > k && arr[j] < value) {
                    value = arr[j];
                }
            }
            
            answer[i] = (value != 1000001) ? value : -1;
        }   
        
        return answer;
    }
}