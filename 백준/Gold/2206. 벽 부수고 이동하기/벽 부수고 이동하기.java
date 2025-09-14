import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N, M;
	static boolean visited[][][];
	static int map[][];

	
	static class Pos {
		int r, c, dist, magic;

		public Pos(int r, int c, int dist, int magic) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.magic = magic;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		visited = new boolean[N + 1][M + 1][2];
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j-1) -'0';
			}
		}
		
		System.out.println(bfs(1,1));

	}

	static int bfs(int r, int c) {
		Queue<Pos> q = new ArrayDeque<>();

		q.offer(new Pos(r, c, 1, 0));
		visited[r][c][0] = true;
		
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			
			
			if(curr.r == N && curr.c == M) {
				return curr.dist;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = dr[d] + curr.r;
				int nc = dc[d] + curr.c;
				
				if(!isValid(nr, nc)) continue;
				
				// 빈칸이면서 방문하지 않았을때
				if (map[nr][nc] == 0 && !visited[nr][nc][curr.magic]) {
					visited[nr][nc][curr.magic] = true; // 방문처리
					q.offer(new Pos(nr, nc, curr.dist + 1, curr.magic));

				}
				// 벽이면서 + 기회 사용 안했을때 + 벽을 한번 부순 상태에서 방문하지 않은 경우
				else if (map[nr][nc] == 1 && curr.magic == 0 && !visited[nr][nc][1]) {
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
