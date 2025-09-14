import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static boolean visited[];
	static List<Integer>[] adj; // 배열 안에 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		} // 필수

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) Collections.sort(adj[i]);

		dfs(V);
		visited = new boolean[N + 1];
		System.out.println();
		bfs(V);

	}

	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");

		for (int nxt : adj[v]) {
			if (!visited[nxt])
				dfs(nxt);
		}

	}

	static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visited[v] = true;

		while (!q.isEmpty()) {

			int curr = q.poll();
			System.out.print(curr + " ");

			for (int nxt : adj[curr]) {
				if (!visited[nxt]) {
					q.offer(nxt);
					visited[nxt] = true;

				}
			}

		}

	}

}
