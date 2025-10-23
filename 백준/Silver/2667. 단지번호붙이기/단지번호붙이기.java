import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dist;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dist = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int totalCnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					int size = bfs(i, j);
					totalCnt++;
					list.add(size);
				}
			}
		}

		sb.append(totalCnt).append("\n");

		Collections.sort(list);
		for (int n : list) sb.append(n).append("\n");

		System.out.println(sb);
	}

	static int max;

	static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		int cnt = 1;
		visited[r][c] = true;
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int curR = curr[0];
			int curC = curr[1];

			for (int d = 0; d < 4; d++) {
				int moveR = curR + dx[d];
				int moveC = curC + dy[d];

				if (moveR >= 0 && moveR < N && moveC >= 0 && moveC < N) {
					if (!visited[moveR][moveC] && map[moveR][moveC] == 1) {
						visited[moveR][moveC] = true;
						q.offer(new int[] { moveR, moveC });
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}