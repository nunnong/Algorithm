import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            Boolean stay = st.nextToken().equals("enter");

            if (stay) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        for (String name : list) {
            System.out.println(name);
        }
    }
}