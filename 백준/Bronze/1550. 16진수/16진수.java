import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 16진수 수를 10진수로 변환해 출력
        Scanner sc = new Scanner(System.in);
        // 입력 값이 문자인 경우와 숫자인 경우로 나누어야?
        // 변환하는 거면 굳이 숫자를 입력하진 않으니까 그렇게 생각을 해야 하나?


        String hex = String.valueOf(sc.nextLine());

        int demical = Integer.parseInt(hex, 16);

        System.out.println(demical);






    }
}