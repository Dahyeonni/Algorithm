import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] miro;
	static boolean[][][] visited;

	static int N, M, Hx, Hy, Ex, Ey;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Pos {
		int r, c, dist, magic;

		public Pos(int r, int c, int dist, int magic) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.magic = magic;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1][M + 1][2]; // 0 : 마법 x , 1 : 마법 o
		miro = new int[N + 1][M + 1];
		// 홍익 위치
		st = new StringTokenizer(br.readLine());
		Hx = Integer.parseInt(st.nextToken());
		Hy = Integer.parseInt(st.nextToken());

		// 탈출 위치
		st = new StringTokenizer(br.readLine());
		Ex = Integer.parseInt(st.nextToken());
		Ey = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 미로 입력 완료

		System.out.println(bfs(Hx, Hy));

	}

	static int bfs(int r, int c) {
		Queue<Pos> q = new ArrayDeque<>();

		q.offer(new Pos(r, c, 0, 0));
		visited[r][c][0] = true;

		while (!q.isEmpty()) {
			Pos curr = q.poll();

			if (curr.r == Ex && curr.c == Ey) {
				return curr.dist;
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				if (!isValid(nr, nc))
					continue;

				// 빈칸이면서 방문하지 않았을때
				if (miro[nr][nc] == 0 && !visited[nr][nc][curr.magic]) {
					visited[nr][nc][curr.magic] = true; // 방문처리
					q.offer(new Pos(nr, nc, curr.dist + 1, curr.magic));

				}
				// 벽이면서 매직 사용 안했을때
				else if (miro[nr][nc] == 1 && curr.magic == 0 && !visited[nr][nc][1]) {
					visited[nr][nc][1] = true;
					q.offer(new Pos(nr, nc, curr.dist + 1, 1));
				}
			}
		}

		return -1;

	}

	static boolean isValid(int nr, int nc) {
		if (nr >= 1 && nc >= 1 && nr < N + 1 && nc < M + 1)
			return true;

		return false;
	}

}
