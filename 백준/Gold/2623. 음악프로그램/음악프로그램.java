import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer>[] adj;
	static int[] degree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		degree = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());

			int from = Integer.parseInt(st.nextToken());
			for (int j = 1; j < cnt; j++) {
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				degree[to]++;
				from = to;
			}

		}

		List<Integer> ans = SingerSort();

		if (ans.size() != N) {
			System.out.println(0);
			return;
		}

		for (int n : ans)
			sb.append(n).append('\n');
		System.out.print(sb);

	}

	static List<Integer> SingerSort() {
		Queue<Integer> q = new ArrayDeque<>();
		List<Integer> res = new ArrayList<>();

		// 진입 차수 0인거 넣기
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int curr = q.poll();
			res.add(curr);

			for (int n : adj[curr]) {
				degree[n]--;
				if (degree[n] == 0)
					q.offer(n);
			}
		}

		return res;

	}

}
