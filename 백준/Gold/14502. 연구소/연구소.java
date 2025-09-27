import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	static int[][] map;
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
			}
		} // 입력완료

		threewall(0,0);

		System.out.println(MAX);

	}


	
    static void threewall(int start, int cnt) {
        if (cnt == 3) {
            virus();
            return;
        }

        for (int idx = start; idx < N * M; idx++) {
            int r = idx / M;
            int c = idx % M;

            if (map[r][c] == 0) {
                map[r][c] = 1;
                threewall(idx + 1, cnt + 1);
                map[r][c] = 0;
            }
        }
    }

	static void virus() {
		Queue<int[]> q = new ArrayDeque<>();
		// 원본 훼손 ㄴㄴ
		int[][] mapCopy = new int[N][M];
		for (int i = 0; i < N; i++) {
			mapCopy[i] = Arrays.copyOf(map[i], M);
		}

		// 2 인 부분 넣어야지
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mapCopy[i][j] == 2) {
					q.offer(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {

			int[] curr = q.poll();

			int currR = curr[0];
			int currC = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + currR;
				int nc = dc[d] + currC;

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (mapCopy[nr][nc] == 0) {
						mapCopy[nr][nc] = 2; // 퍼트리기
						q.add(new int[] { nr, nc });
					}
				}
			}
		}
		// 안전영역 확인
		int clear = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mapCopy[i][j] == 0)
					clear++;
			}
		}

		MAX = Math.max(MAX, clear);

	}

}
