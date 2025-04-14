import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static int n, m;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // 0이면 합치기, 1이면 포함인지 확인 연산

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (operator == 0) {
                union(a, b);
                
            } else if (operator == 1) {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }

    private static int find(int x) {
        // 조상 찾기!
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }

    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
