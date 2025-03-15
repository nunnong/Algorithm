import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N개의 숫자 카드 입력
        int N = Integer.parseInt(br.readLine());
        String[] inputN = br.readLine().split(" ");
        Map<Integer, Integer> cardCount = new HashMap<>();

        // 숫자 카드 개수 저장
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(inputN[i]);
            cardCount.put(num, cardCount.getOrDefault(num, 0) + 1);
        }

        // M개의 숫자 입력
        int M = Integer.parseInt(br.readLine());
        String[] inputM = br.readLine().split(" ");

        // 숫자 카드 개수 출력
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(inputM[i]);
            bw.write(cardCount.getOrDefault(num, 0) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
