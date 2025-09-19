import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] board;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				ans = Math.min(ans, check(i, j));
			}
		}
		System.out.println(ans);

	}

	static int check(int r, int c) {

		int W = 0;
		int B = 0;

		for (int k = 0; k < 8; k++) {
			for (int l = 0; l < 8; l++) {
				char what = board[r + k][c + l]; // 칸
				if ((k + l) % 2 == 0) { // 짝수는 시작 색
					if (what != 'W')
						W++;
					if (what != 'B')
						B++;
				} else { // 홀수는 반대
					if (what != 'B')
						W++;
					if (what != 'W')
						B++;

				}

			}
		}
		return Math.min(W, B);
	}

}
