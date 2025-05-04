import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static int[] size = {4, 2, 3, 3, 3, 3, 3, 3, 3, 3};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            char[] tmp = br.readLine().toCharArray();
            if (tmp[0] == '0') break;

            int len = tmp.length;
            int width = 0;
            for (int i = 0; i < len; i++) {
                width += size[tmp[i] - '0'];
            }

            width += (len + 1);
            System.out.println(width);
        }
    }
}
