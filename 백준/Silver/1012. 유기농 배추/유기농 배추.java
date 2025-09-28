import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			} // 입력 완료

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			sb.append(cnt).append("\n");

		} // 테스트 케이스 끝

		System.out.println(sb);

	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {

			int[] curr = q.poll();

			int curR = curr[0];
			int curC = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + curR;
				int nc = dc[d] + curC;

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 1 && !visited[nr][nc]) {
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}

	}

}
