import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int map[][] = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			} // map 입력 데이터 끝

			int ans = 0;

			// 행에서 찾기
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					// 흰색
					if (map[i][j] == 1) {
						cnt++;
					}
					// 검정
					else {
						if (cnt == K)
							ans++;
						cnt = 0;
					}

				}
				if (cnt == K)
					ans++;
			}

			// 열에서 찾기
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					// 흰색
					if (map[j][i] == 1) {
						cnt++;
					}
					// 검정
					else {
						if (cnt == K)
							ans++;
						cnt = 0;
					}

				}
				if (cnt == K)
					ans++;
			}

			sb.append("#" + (t + 1) + " " + ans + "\n");

		}
		System.out.println(sb);

	}

}
