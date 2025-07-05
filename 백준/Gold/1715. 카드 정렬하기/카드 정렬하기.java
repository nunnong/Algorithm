import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        // 작은 것들 먼저 골라서 합치기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();

            sum += num1 + num2;
            pq.offer(num1 + num2);
        }

        System.out.println(sum);
    }
}
