import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static List<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			adj = new ArrayList[101];
			visited = new boolean[101];

			for (int i = 1; i <= 100; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < N / 2; i++) {
				if (i == 0)
					st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adj[from].add(to);
			}

			int res = bfs(V);
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.print(sb);

	}

	static int bfs(int v) {
		Deque<Integer> q = new ArrayDeque<>();
		Arrays.fill(visited, false);

		q.add(v);
		visited[v] = true;

		int ans = v;

		while (!q.isEmpty()) {

			int size = q.size();
			int max = 0;

			for (int i = 0; i < size; i++) {

				int cur = q.poll();
				max = Math.max(max, cur);

				for (int nxt : adj[cur]) {
					if (!visited[nxt]) {
						q.add(nxt);
						visited[nxt] = true;
					}

				}
			}

			ans = max;

		}
		return ans;
	} // bfs 완료

}
