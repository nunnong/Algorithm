import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] isPrime = new int[N+1];
		
		for (int i = 0 ; i <= N ; i++) {
			isPrime[i] =i;
		}
		
		isPrime[0] = isPrime[1] = -1;
		
		for (int i = 2 ; i*i <= N ; i++) {
			if (isPrime[i] != -1) {
				for(int j = i*i ; j <=N ; j+=i) {
					isPrime[j] = -1;
				}
			} continue;
		}
		
		
		for (int i : isPrime) {
			if (i >= M) {
				System.out.println(i);
			}
		}
	}
	

}
