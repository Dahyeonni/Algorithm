import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	static int[][] map;
	static int firstBlank = 0;
	static int MAX = -1; // 계속 비교 되어야 하니까 전역

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					firstBlank++; // 초기빈칸
			}
		} // 입력완료

		threewall(0, 0);

		System.out.println(MAX);

	}

	static void threewall(int start, int cnt) {
		if (cnt == 3) {
			virus();
			return;
		}
		// 평탄화 작업
		for (int idx = start; idx < N * M; idx++) {
			int r = idx / M;
			int c = idx % M;// 둘다 M 인 것에 주의

			if (map[r][c] == 0) {
				map[r][c] = 1;
				threewall(idx + 1, cnt + 1);
				map[r][c] = 0;
			}
		}
	}

	static void virus() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];

		int infected = 0;

		// 바이러스 위치 전부 큐에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					q.offer(new int[] { i, j });
					visited[i][j] = true; // 기존 바이러스는 방문처리
				}
			}
		}

		// BFS로 바이러스 퍼뜨리기
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0], c = cur[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (!visited[nr][nc] && map[nr][nc] == 0) {
						visited[nr][nc] = true;
						infected++;
						q.add(new int[] { nr, nc });
					}
				}
			}
		}

		// 첫빈칸 - 벽3- 바이러스
		int safe = firstBlank - 3 - infected;
		MAX = Math.max(MAX, safe);
	}
}
