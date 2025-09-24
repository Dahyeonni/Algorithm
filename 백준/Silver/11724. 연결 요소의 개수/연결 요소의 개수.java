import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static boolean[] visited;
	static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			adj[A].add(B);
			adj[B].add(A);
		} // 방향 없음

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int a : adj[curr]) {
				if (!visited[a]) {
					visited[a] = true;
					q.add(a);
				}
			}
		}

	}

}
