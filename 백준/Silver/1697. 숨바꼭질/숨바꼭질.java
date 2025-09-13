import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, K;
	static final int max = 100000;
	static boolean[] visited = new boolean[max+1];
	static int[] dist = new int[max+1];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		bfs(N, K);

	}

	static void bfs(int start, int end) {
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(start);
		visited[start] = true;
		dist[start] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == end) {
				System.out.println(dist[cur]);
				return;
			}

			for (int move : new int[] { cur - 1, cur + 1, cur * 2 }) {
				if (isValid(move) && !visited[move]) {
					dist[move] = dist[cur] + 1;
					q.offer(move);

					visited[move] = true;
				}
			}
		}

		return;

	}

	static boolean isValid(int idx) {
		return idx >= 0 && idx <= max;
	}

}
