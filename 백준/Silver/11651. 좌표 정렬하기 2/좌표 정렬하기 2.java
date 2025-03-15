import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); // 점의 개수 입력
        List<int[]> points = new ArrayList<>();

        // 좌표 입력
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            points.add(new int[]{x, y});
        }

        // 정렬: y좌표 기준 오름차순, y좌표가 같으면 x좌표 기준 오름차순
        points.sort((p1, p2) -> {
            if (p1[1] == p2[1]) return Integer.compare(p1[0], p2[0]); // x좌표 정렬
            return Integer.compare(p1[1], p2[1]); // y좌표 정렬
        });

        // 정렬된 좌표 출력
        for (int[] point : points) {
            bw.write(point[0] + " " + point[1] + "\n");
        }
        
        bw.flush(); // 출력 최적화
        br.close();
        bw.close();
    }
}