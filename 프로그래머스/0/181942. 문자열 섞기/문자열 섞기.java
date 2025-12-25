class Solution {
    public String solution(String str1, String str2) {
        
        char[] text1 = str1.toCharArray();
        char[] text2 = str2.toCharArray();
        
        String answer = "";
        for (int i = 0 ; i < text1.length ; i++) {
            answer += text1[i];
            answer += text2[i];
        }
        
        return answer;
    }
}