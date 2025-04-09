import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static List<List<Node>> graph;
	static int start, end;
	static int[] distance;
	
	static class Node implements Comparable<Node>{
		int v;
		int weight;
		
		public Node(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 정점
		int M = Integer.parseInt(br.readLine()); // 간선
		int INF = Integer.MAX_VALUE;
		
		// 인접 리스트 초기화
		graph = new ArrayList<>();
		for (int i = 0 ; i <= N ; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		distance = new int[N+1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		for (int i = 0 ; i < M ; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(new Node(v2, weight));
			
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra();
		
		System.out.println(distance[end]);
		
	}

	private static void dijkstra() {
		// TODO Auto-generated method stub
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll();
			
			if (distance[node.v] < node.weight) continue;
			
			for (Node next : graph.get(node.v)) {
				int newDist = node.weight + next.weight;
				if (distance[next.v] > newDist) {
					distance[next.v] = newDist;
					pq.add(new Node(next.v, newDist));
				}
			}
		}
	}

}
