
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // 여러 개의 테스트 케이스를 받는다.
        while (true) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            if (num1 == 0 && num2 == 0) {
                break;
            }

            if (num1 > num2) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }


        }

    }
}