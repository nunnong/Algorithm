import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 명령어 개수
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                // push 명령어는 항상 공백을 포함하고 있으므로, 첫 번째 공백의 인덱스를 찾아 숫자만 추출
                int spaceIndex = command.indexOf(" ");
                String cmdType = command.substring(0, spaceIndex);
                int value = Integer.parseInt(command.substring(spaceIndex + 1));

                if (cmdType.equals("push_front")) {
                    deque.addFirst(value);
                } else { // "push_back"
                    deque.addLast(value);
                }
            } else if (command.equals("pop_front")) {
                bw.write((deque.isEmpty() ? "-1" : deque.pollFirst()) + "\n");
            } else if (command.equals("pop_back")) {
                bw.write((deque.isEmpty() ? "-1" : deque.pollLast()) + "\n");
            } else if (command.equals("size")) {
                bw.write(deque.size() + "\n");
            } else if (command.equals("empty")) {
                bw.write((deque.isEmpty() ? "1" : "0") + "\n");
            } else if (command.equals("front")) {
                bw.write((deque.isEmpty() ? "-1" : deque.peekFirst()) + "\n");
            } else if (command.equals("back")) {
                bw.write((deque.isEmpty() ? "-1" : deque.peekLast()) + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
