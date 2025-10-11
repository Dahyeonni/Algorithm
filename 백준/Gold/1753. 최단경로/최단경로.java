import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {

		int to, cost;

		// 출발, 가중치
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		// 오름차순으로 비교 -> this > o => 양수
		// 비용이 작을 수록 우선순위 높게(앞으로)

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static int V, E, K;
	static int INF = Integer.MAX_VALUE;
	static List<Edge>[] adj;
	static int[] dist;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// 시작 정점
		K = Integer.parseInt(br.readLine());

		adj = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		dist = new int[V + 1];
		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			// from 시작
			int u = Integer.parseInt(st.nextToken());
			// to 도착
			int v = Integer.parseInt(st.nextToken());
			// cost 가중치
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Edge(v, w));
		}

		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}

	}

	static void dijkstra(int K) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];

		dist[K] = 0; // 시작노드까지 거리는 0으로 초기화

		pq.add(new Edge(K, 0));

		while (!pq.isEmpty()) {

			Edge curr = pq.poll();

			// 현재뽑은 노드
			if (visited[curr.to])
				continue;

			// 더 짧은 경로가 나중에 생길 수 있으니, 나중에 방문처리
			visited[curr.to] = true;

			for (Edge node : adj[curr.to]) {
				// 이웃노드 방문
				if (!visited[node.to] &&
				// 이웃 노드 거리 > 현재 노드 거리 + 그곳으로 갈 가중치
				// 지금 알고 있는 거리 vs 새로 찾은 거리
						dist[node.to] > dist[curr.to] + node.cost) {

					dist[node.to] = dist[curr.to] + node.cost;
					pq.add(new Edge(node.to, dist[node.to]));

				}

			}
		}

	}

}
