import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine()); // 연결 개수
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) { // 0번 인덱스는 안 씀.
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        cnt = 0;
        visited[1] = true;
        dfs(1);

        System.out.println(cnt);
    }

    private static void dfs(int node) {
        for (int i : list[node]) {
            if (!visited[i]) {
                visited[i] = true;
                cnt++;
                dfs(i);
            }
        }

    }
}
