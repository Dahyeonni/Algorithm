import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = { 2, 2, -2, -2, 1, -1, 1, -1 };
	static int[] dc = { -1, 1, -1, 1, 2, -2, -2, 2 };
	static int[][] map;
	static int L;
	static boolean[][] visited;
	static int startR, startC, endR, endC;
	static int dist[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			L = sc.nextInt();
			map = new int[L][L];
			visited = new boolean[L][L];
			dist = new int[L][L];

			startR = sc.nextInt();
			startC = sc.nextInt();

			endR = sc.nextInt();
			endC = sc.nextInt();

			bfs(startR, startC);

		} // 테스트 케이스 끝
	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { r, c });
		visited[r][c] = true;
		dist[r][c] = 0;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currR = curr[0];
			int currC = curr[1];

			// 마지막 정점 도착하면 return
			if (currR == endR && currC == endC) {
				System.out.println(dist[currR][currC]);
				return;
			}

			for (int d = 0; d < 8; d++) {
				int nr = dr[d] + currR;
				int nc = dc[d] + currC;

				if (!isValid(nr, nc) || visited[nr][nc])
					continue;

				dist[nr][nc] = dist[currR][currC] + 1;

				visited[nr][nc] = true;
				q.offer(new int[] { nr, nc });
			}

		}

	}

	static boolean isValid(int nr, int nc) {
		return (nr >= 0 && nr < L && nc >= 0 && nc < L);
	}
}
