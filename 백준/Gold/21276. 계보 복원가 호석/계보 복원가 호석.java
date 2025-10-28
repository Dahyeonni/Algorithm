import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String[] pp = new String[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			pp[i] = st.nextToken();

		Arrays.sort(pp);

		Map<String, Integer> mapping = new HashMap<>();

		for (int i = 0; i < N; i++)
			mapping.put(pp[i], i);

		int M = Integer.parseInt(br.readLine());

		List<Integer>[] adj = new ArrayList[N];
		List<Integer>[] child = new ArrayList[N];
		int[] degree = new int[N];

		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
			child[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String grandchild = st.nextToken();
			String ancestor = st.nextToken();

			int from = mapping.get(ancestor);
			int to = mapping.get(grandchild);

			adj[from].add(to);
			degree[to]++;

		}

		Queue<Integer> q = new ArrayDeque<>();
		List<Integer> root = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			if (degree[i] == 0) {
				q.add(i);
				root.add(i);
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int nxt : adj[curr]) {
				degree[nxt]--;
				if (degree[nxt] == 0) {
					child[curr].add(nxt); 
					q.add(nxt);
				}
			}
		}

		sb.append(root.size()).append("\n");
		for (int r : root) {
			sb.append(pp[r]).append(" ");
		}
		sb.append("\n");

		for (int i = 0; i < N; i++) {
			Collections.sort(child[i]);
		}

		for (int i = 0; i < N; i++) {
			sb.append(pp[i]).append(" ").append(child[i].size());
			for (int c : child[i]) {
				sb.append(" ").append(pp[c]);
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

}
