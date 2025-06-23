import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                stack.push(num);
            } else {
                stack.pop();
            }
        }

        int sum = 0;
        for (Integer num : stack) {
            sum += num;
        }
        System.out.println(sum);
    }
}
