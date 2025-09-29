import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료

		solve(0, 0, N);

		sb.append(white).append("\n").append(blue);
		System.out.println(sb);

	}

	static void solve(int r, int c, int N) {

		if (same(r, c, N)) {
			if (map[r][c] == 0)
				white++;
			else
				blue++;
			return;
		}

		int half = N / 2;

		solve(r, c, half); // 좌상
		solve(r, c + half, half); // 우상
		solve(r + half, c, half); // 좌하
		solve(r + half, c + half, half); // 우하

	}

	static boolean same(int r, int c, int N) {
		int color = map[r][c];

		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}

		return true;

	}

}
