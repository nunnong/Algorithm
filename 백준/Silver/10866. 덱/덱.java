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
		Deque<String> deque = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().trim().split(" ");
            
            switch (tmp[0]) {
                case "push_front":
                	deque.addFirst(tmp[1]);
                    break;
                case "push_back":
                	deque.addLast(tmp[1]);
                	break;
                	
                case "pop_front":
                	bw.write((deque.isEmpty() ? -1 : deque.removeFirst()) + "\n");
                    break;
                case "pop_back":
                	bw.write((deque.isEmpty() ? -1 : deque.removeLast()) + "\n");
                	break;
                	
                case "size":
                	bw.write(deque.size() + "\n");
                	break;
                case "empty":
                	bw.write(((deque.isEmpty()) ? 1 : 0) + "\n");
                	break;
                case "front":
                    bw.write((deque.isEmpty() ? -1 : deque.peekFirst()) + "\n");
                    break;
                case "back":
                    bw.write((deque.isEmpty() ? -1 : deque.peekLast()) + "\n");
                    break;
            }
        }
		br.close();
		bw.flush();
		bw.close();
		
	}// main

}
