import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	// 우, 하, 좌, 상
	static int[] dx = {0, 1, 0, -1}; //row
	static int[] dy = {1, 0, -1, 0}; //col
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			// 현재 x, y의 위치
			int x = 0;
			int y = 0;
			
			int dir = 0; // 초기 방향(오른쪽)
			
			int[][] map = new int[N][N];

			map[x][y] = 1; // 첫 번째 숫자 배치
			
			for (int i = 2; i <= N * N; i++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				// 배열 범위를 벗어나거나 이미 숫자가 있는 경우 방향 변경
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0) {
					dir = (dir + 1) % 4; // 방향 변경
					nx = x + dx[dir];
					ny = y + dy[dir];
				}

				map[nx][ny] = i;
				x = nx;
				y = ny;
			}
			
			
			System.out.println("#" + tc);
			
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	
	}
	
}
