// 섬의 개수

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int w, h;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, -1, 0, 1, -1, 1, -1, 1 };

	static boolean[][] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0)
				break; // 종료

			map = new int[h][w];
			visited = new boolean[h][w];

			// 1은 땅 0은 바다
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			} // 입력 완료
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);

		}
	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			int nxtR = curr[0];
			int nxtC = curr[1];
			
			for(int d = 0; d < 8; d++) {
				int nr = dr[d] + nxtR;
				int nc = dc[d] + nxtC;
				
				
				if(!isValid(nr, nc) || visited[nr][nc] || map[nr][nc] == 0) {
					continue;
				}
				
				q.offer(new int[] {nr, nc});
				
				visited[nr][nc] = true;
				
			} 
		}
		return;
	}
	static boolean isValid(int nr, int nc) {
		return (nr >= 0 && nr < h && nc >= 0 && nc < w);
	}
}
