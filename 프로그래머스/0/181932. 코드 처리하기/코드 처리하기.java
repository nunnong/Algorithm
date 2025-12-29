class Solution {
    public String solution(String code) {
        
        boolean mode = false;
        
        char[] text = code.toCharArray();
        
        StringBuilder ret = new StringBuilder();
        
        for (int i = 0 ; i < text.length ; i++) {
            if (text[i] == '1') {
                mode = !mode;
                continue;
            }
            
            if (!mode && i % 2 == 0) {
                ret.append(text[i]);
                continue;
            }
            
            if (mode && i % 2 == 1) {
                ret.append(text[i]);
                continue;
            }
        }
        
        return (ret.length() == 0) ? "EMPTY" : ret.toString();
    }
}