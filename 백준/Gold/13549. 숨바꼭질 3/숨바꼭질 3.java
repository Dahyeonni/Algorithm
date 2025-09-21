import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	static final int size = 100000;
	static int N, K;

	static int[] dist;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		dist = new int[size + 1];
		Arrays.fill(dist, -1);

		int ans = bfs(N);
		System.out.println(ans);
	}

	static int bfs(int n) {
		Deque<Integer> dq = new ArrayDeque<>();

		dq.add(n);
		dist[n] = 0;

		while (!dq.isEmpty()) {
			int curr = dq.poll();

			if (curr == K)
				return dist[curr];

			// 순간이동
			int sungan = curr * 2;
			if(sungan <= size && dist[sungan] == -1) {
				dist[sungan] = dist[curr];
				dq.addFirst(sungan); // 앞에 넣기
			}

			// 그외
			int pos[] = new int[] { curr - 1, curr + 1 };

			for (int d = 0; d < 2; d++) {
				int nxt = pos[d];

				if (nxt < 0 || nxt > size || dist[nxt] != -1)
					continue;

				dq.addLast(nxt); // 원래대로
				dist[nxt] = dist[curr] + 1;
			}
		}
		return -1;
	}

}
