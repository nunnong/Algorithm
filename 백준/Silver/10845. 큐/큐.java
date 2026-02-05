import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            // push or pop
            if (line.charAt(0) == 'p') {
                if (line.charAt(1) == 'u') { // push X
                    q.offer(Integer.parseInt(line.substring(5)));
                } else { // pop
                    sb.append(q.isEmpty() ? -1 : q.poll()).append('\n');
                }
            }
            else if (line.charAt(0) == 's') { // size
                sb.append(q.size()).append('\n');
            }
            else if (line.charAt(0) == 'e') { // empty
                sb.append(q.isEmpty() ? 1 : 0).append('\n');
            }
            else if (line.charAt(0) == 'f') { // front
                sb.append(q.isEmpty() ? -1 : q.peekFirst()).append('\n');
            }
            else { // back
                sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
