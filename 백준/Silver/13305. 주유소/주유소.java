import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class City {
        int Liter; //  1리터당 가격
        int Length; // 이전 도시부터 현재까리 거리

        public City(int liter, int length) {
            Liter = liter;
            Length = length;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        City[] cities = new City[N];

        for (int i = 0 ; i < N ; i++) {
            cities[i] = new City(0,0);
        }

        cities[0].Length = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i < N ; i++) {
            cities[i].Length = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            cities[i].Liter = Integer.parseInt(st.nextToken());
        }

        int minPrice = cities[0].Liter; // 리터당 가격 최솟값

        long totalPrice = 0;

        for (int i = 0 ; i < N-1 ; i++) {
            minPrice = Math.min(minPrice, cities[i].Liter);
            totalPrice += (long) cities[i + 1].Length * minPrice;
        }

        System.out.println(totalPrice);


    }
}
