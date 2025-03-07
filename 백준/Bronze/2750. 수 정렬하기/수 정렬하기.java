import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {
	// N <= 1000 ; N^2 까지는 ok
	static int[] arr;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		for (int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 퀵정렬
		quickSort(0, N-1);
		for (int i = 0 ; i < N ; i++) {
			System.out.println(arr[i]);
		}
		
	}//main
	
	
	// 정렬!
	private static void quickSort(int start, int end) {
		if (start < end) {
			int pivot = partition(start, end);
			quickSort(start, pivot-1);
			quickSort(pivot+1, end);
		}
		
	}
	
	// pivot 정하기
	private static int partition(int start, int end) {
		int pivot = arr[start];
		
		int L = start+1; // start는 pivot이니까!
		int R = end;
		
		while(L <= R) {
			while(L <= end && arr[L]<= pivot) L++;
			while(R > start && arr[R] >= pivot) R--;
			
			if (L < R) { // pivot 기준 오른쪽 있는 L, 왼쪽에 있는 R 서로 교환
				int temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			} 
		}//while
		
		// R과 피봇 위치를 교환
		int temp = arr[start];
		arr[start] = arr[R];
		arr[R] = temp;
		
		return R;
	}
	
}
