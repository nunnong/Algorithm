import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                arr.add(name);
            }
        }

        System.out.println(arr.size());
        Collections.sort(arr);

        for (String name : arr) {
            System.out.println(name);
        }
    }
}