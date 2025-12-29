class Solution {
    public String solution(String code) {

        StringBuilder ret = new StringBuilder();
        boolean mode = false;

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);

            if (c == '1') {
                mode = !mode;
                continue; 
            }

            if (!mode && i % 2 == 0) {
                ret.append(c);
            } else if (mode && i % 2 == 1) {
                ret.append(c);
            }
        }

        return ret.length() == 0 ? "EMPTY" : ret.toString();
    }
}
