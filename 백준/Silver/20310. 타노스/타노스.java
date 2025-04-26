import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().trim().split("");
        int zero = 0 , one = 0; // 0과 1의 개수

        for (int i = 0 ; i < tmp.length ; i++) {
            if (tmp[i].equals("0")) {
                zero++;
            } else {
                one++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int zeroCnt = zero/2;
        int oneCnt = one/2;

        for (int i = 0 ; i < tmp.length ; i++) {
            if (tmp[i].equals("0") && zeroCnt != 0) {
                sb.append("0");
                zeroCnt--;

            } else if (tmp[i].equals("1")) {
                if (oneCnt <= 0 ) {
                    sb.append("1");
                } else {
                    oneCnt--;
                }
            }
        }

        System.out.println(sb);



    }
}
