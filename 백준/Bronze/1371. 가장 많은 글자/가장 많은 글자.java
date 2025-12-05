import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[26];
        String line;

        while ((line = br.readLine()) != null) { 
            StringTokenizer st = new StringTokenizer(line);

            while (st.hasMoreTokens()) {
                String token = st.nextToken();

                // 알파벳 문자만 카운트
                for (char c : token.toCharArray()) {
                    if ('a' <= c && c <= 'z') {
                        cnt[c - 'a']++;
                    }
                }
            }
        }

        int max = cnt[0];
        
        for (int i = 0 ; i < 26 ; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        
        for (int i = 0 ; i < 26 ; i++) {
            if (cnt[i] == max) {
                sb.append((char)(i + 'a'));
            }
        }

        System.out.println(sb.toString());
    }
}
