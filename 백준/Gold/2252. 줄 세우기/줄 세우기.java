import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		// 진입 차수 배열
		int[] inDegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			inDegree[to]++;
		}

		Queue<Integer> q = new ArrayDeque<>();

		// 진입 차수가 0인거 큐에 넣기
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0)
				q.add(i);
		}

		while (!q.isEmpty()) {
			// 0 이었던 거중에서 큐에서 빼기 (순서는 상관없음)
			int from = q.poll();
			sb.append(from).append(" ");
			
			// 관련된 간선들 다 끊기
			for (int i = 0; i < adj[from].size(); i++) {
				int num = adj[from].get(i);
				inDegree[num]--;
				if (inDegree[num] == 0)
					q.add(num);

			}
		}

		System.out.println(sb);

	}

}
