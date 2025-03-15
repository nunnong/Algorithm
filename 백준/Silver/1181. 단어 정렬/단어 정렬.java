import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> wordSet = new HashSet<>(); // 중복 제거

        for (int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }

        // 리스트로 변환 후 정렬
        List<String> wordList = new ArrayList<>(wordSet);
        wordList.sort((a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length()); // 길이 기준 정렬
            }
            return a.compareTo(b); // 사전 순 정렬
        });

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String word : wordList) {
            bw.write(word + "\n");
        }
        bw.flush();
        bw.close();
    }
}