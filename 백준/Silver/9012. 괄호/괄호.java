import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수 입력

        for (int i = 0; i < T; i++) {
            String input = br.readLine();  // 괄호 문자열 입력
            System.out.println(isVPS(input) ? "YES" : "NO");
        }
    }

    // 괄호 문자열이 올바른지 판단하는 함수
    public static boolean isVPS(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);  // 여는 괄호는 스택에 넣음
            } else { // 닫는 괄호인 경우
                if (stack.isEmpty()) {
                    return false;  // 스택이 비어있으면 올바른 괄호 문자열이 아님
                }
                stack.pop();  // 한 쌍이 맞으므로 스택에서 제거
            }
        }
        return stack.isEmpty();  // 스택이 비어있어야 올바른 VPS
    }
}