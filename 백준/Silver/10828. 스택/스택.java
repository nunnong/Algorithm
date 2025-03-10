import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 명령어 개수
		Stack<String> stack = new Stack<String>();
		
		for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().trim().split(" ");
            
            switch (tmp[0]) {
                case "push":
                    stack.push(tmp[1]);
                    break;
                case "top":
                    bw.write((stack.isEmpty() ? -1 : stack.peek()) + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "pop":
                    bw.write((stack.isEmpty() ? -1 : stack.pop()) + "\n");
                    break;
                case "empty":
                    bw.write((stack.isEmpty() ? 1 : 0) + "\n");
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
	}

}
