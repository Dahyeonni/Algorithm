import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K;
	static int[][] map;
	static int[][] dist;
	static int[][] ans;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];


		int targetR = -1;
		int targetC = -1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = -1; // 초기값 -1
				if (map[i][j] == 2) { // 시작점 찾기
					targetR = i;
					targetC = j;
				}
			}
		}

		bfs(targetR, targetC);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					sb.append(0).append(" ");
				else
					sb.append(dist[i][j]).append(" ");

			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { r, c });
		dist[r][c] = 0;
		visited[r][c] = true;

		while (!q.isEmpty()) {

			int[] curr = q.poll();

			int curR = curr[0];
			int curC = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + curR;
				int nc = dc[d] + curC;

				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if (!visited[nr][nc] && map[nr][nc] == 1) {
						visited[nr][nc] = true;
						dist[nr][nc] = dist[curR][curC] + 1;
						q.offer(new int[] { nr, nc });
					}
				}
			}

		}

	}

}
