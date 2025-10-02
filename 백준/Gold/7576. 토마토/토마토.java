import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M;
	static int[][] box;
	static int[][] dist;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		dist = new int[N][M];

		boolean already = true;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 0)
					already = false;
			}
		} // 입력 완료

		if (already) {
			System.out.println(0);
			return;
		}

		q = new ArrayDeque<>();
		// 1인 좌표를 큐에 미리 넣고, 다 돌았으면
		// 그 상태에서 BFS실행
		//
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {
					q.offer(new int[] { i, j });
				}
			}
		} // 입력 완료

		bfs();
		int ans = 0;
		boolean done = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					done = false;
				}
				ans = Math.max(ans, dist[i][j]);
			}
		}

		if (done)
			System.out.println(ans);
		else
			System.out.println(-1);

	}

	// 모두 익어 있으면 0이고, 익지 못하면 -1
	static void bfs() {

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int curR = curr[0];
			int curC = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + curR;
				int nc = dc[d] + curC;

				// 경계값 확인
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (box[nr][nc] == 0 && dist[nr][nc] == 0) {
						q.offer(new int[] { nr, nc });
						box[nr][nc] = 1; // 익게 만들기
						dist[nr][nc] = dist[curR][curC] + 1;
					}
				}

			}
		}

		return;
	}

}
