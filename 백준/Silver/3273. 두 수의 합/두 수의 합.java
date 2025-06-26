import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    // n * log n 까지 가능 시간초과 -> 더 효율적인 방법! 찾기
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = Integer.parseInt(br.readLine());

        Set<Integer> arr = new HashSet<>();

        for (int i = 0 ; i < n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > result/2) {
                arr.add(num);
            } else {
                arr.add(result - num);
            }
        }

        System.out.println(n - arr.size());



    }
}
