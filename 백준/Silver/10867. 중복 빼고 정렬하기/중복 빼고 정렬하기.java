import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 정수 개수 입력
        String[] input = br.readLine().split(" ");
        
        Set<Integer> numberSet = new TreeSet<>(); // 중복 제거 + 자동 정렬

        // 정수 입력 및 저장
        for (int i = 0; i < N; i++) {
            numberSet.add(Integer.parseInt(input[i]));
        }

        // 출력
        for (int num : numberSet) {
            bw.write(num + " ");
        }

        bw.flush(); // 출력 최적화
        br.close();
        bw.close();
    }
}
