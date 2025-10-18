import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Edge implements Comparable<Edge> {
		int to, cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static List<Edge>[] adj;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		adj = new ArrayList[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, INF);

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			adj[from].add(new Edge(to, cost));
		}

		int start = sc.nextInt();
		int end = sc.nextInt();

		dijkstra(start);

		System.out.println(dist[end]);

	}

	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];

		dist[start] = 0;

		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();

			if (visited[curr.to])
				continue;

			visited[curr.to] = true;

			for (Edge node : adj[curr.to]) {
				if (!visited[node.to] && dist[node.to] > dist[curr.to] + node.cost) {
					dist[node.to] = dist[curr.to] + node.cost;
					pq.add(new Edge(node.to, dist[node.to]));
				}
			}

		}

	}

}
