import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Point[] pointX = new Point[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pointX[i] = new Point(x, y); // 객체 초기화 필수!
        }

        // x 기준 정렬, 같으면 y 기준
        Arrays.sort(pointX, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if (p1.x != p2.x) return p1.x - p2.x;
                return p1.y - p2.y;
            }
        });

        int sum = 0;
        for (int i = 0; i < N; i += 2) {
            int diff = Math.abs(pointX[i + 1].y - pointX[i].y);
            sum += diff;
        }

        // y 기준 정렬, 같으면 x 기준
        Arrays.sort(pointX, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if (p1.y != p2.y) return p1.y - p2.y;
                return p1.x - p2.x;
            }
        });

        for (int i = 0; i < N; i += 2) {
            int diff = Math.abs(pointX[i + 1].x - pointX[i].x);
            sum += diff;
        }

        System.out.println(sum);
    }
}
