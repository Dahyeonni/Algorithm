
import java.util.Scanner;

public class Solution {
	static int N, M;
	static boolean[][] valid;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			valid = new boolean[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				valid[a][b] = true;
			}
			// 경도둑
			for (int k = 1; k <= N; k++) { // 경유지
				for (int from = 1; from <= N; from++) { // 출발지
					if (!valid[from][k])
						continue;
					for (int to = 1; to <= N; to++) { // 도착지
						if (!valid[k][to])
							continue;
						valid[from][to] = true;
					}
				}

			}

			int knowpp = 0;

			for (int from = 1; from <= N; from++) {

				int small = 0, tall = 0;

				for (int to = 1; to <= N; to++) {
					if (valid[from][to])
						tall++;
					if (valid[to][from])
						small++;
				}

				if (tall + small == N - 1)
					knowpp++;

			}

			sb.append("#").append(t).append(" ").append(knowpp).append("\n");

		} // 테케 완료
		System.out.print(sb);
	}

}
