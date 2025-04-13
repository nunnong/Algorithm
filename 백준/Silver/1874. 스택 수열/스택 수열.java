import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{

    static int n;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int idx = 1; // --> 1~
        outer:
        for (int i = 0 ; i < n ; i++) {
            int num = Integer.parseInt(br.readLine());

            while (idx <= num) {
                stack.push(idx++);
                sb.append("+").append("\n");
            }
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                flag = true;
                break outer;
            }
        }

        if (flag) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }

    }
}
