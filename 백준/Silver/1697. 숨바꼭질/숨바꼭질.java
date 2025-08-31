import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        if (N >= K) {
            System.out.println(N - K);
            return; // return 추가
        }

        boolean[] visited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{N, 0}); // 수빈 위치, time
        visited[N] = true; // 시작점 visited 설정

        while (!queue.isEmpty()) {

            int[] node = queue.poll();
            int p = node[0];
            int t = node[1];

            if (p == K) {
                System.out.println(t);
                return;
            }

            // p+1로 이동
            if (p+1 >= 0 && p+1 <= 100000 && !visited[p+1]) {
                visited[p+1] = true;
                queue.offer(new int[]{p+1, t+1});
            }

            // p-1로 이동
            if (p-1 >= 0 && p-1 <= 100000 && !visited[p-1]) {
                visited[p-1] = true;
                queue.offer(new int[]{p-1, t+1});
            }

            // p*2로 이동
            if (p*2 >= 0 && p*2 <= 100000 && !visited[p*2]) {
                visited[p*2] = true;
                queue.offer(new int[]{p*2, t+1});
            }
        }
    }
}