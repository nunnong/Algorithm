import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String bookName = br.readLine();
            map.put(bookName, map.getOrDefault(bookName, 0) + 1);
        }

        String bestBook = "";
        int maxCount = 0;

        for (String book : map.keySet()) {
            int count = map.get(book);

            if (count > maxCount) {
                bestBook = book;
                maxCount = count;
            } else if (count == maxCount && book.compareTo(bestBook) < 0) {
                bestBook = book;
            }
        }

        System.out.println(bestBook);
    }
}