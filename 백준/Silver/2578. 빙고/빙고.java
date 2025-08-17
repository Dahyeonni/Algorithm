// 빙고
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N = 5;
	static int bingo[][] = new int[N][N];
	static int oneBingo;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 철수 빙고 채우기 완료

		int cnt = 0; // 사회자가 부른 횟수
		outer:
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int ans = Integer.parseInt(st.nextToken());
				cnt++; // 사회자 부를 때마다 횟수 증가

				for (int c = 0; c < N; c++) {
					for (int r = 0; r < N; r++) {
						if (ans == bingo[c][r]) {
							bingo[c][r] = 0;
						} // 사회자가 부른거 0으로 표시
					}
				} // 철수 빙고판에서 체크 완료

				// 가로 & 세로 & 대각선
				oneBingo = 0;
				rowBingo();
				colBingo();
				LtoRcross();
				RtoLcross();
				
				
				if(oneBingo >= 3) {
					break outer;
				}
				

			}
		} // 사회자 빙고 부르기 완료

		System.out.println(cnt);

	}

	// 가로
	public static void rowBingo() {
		for (int i = 0; i < N; i++) {
			int check = 0;
			for (int j = 0; j < N; j++) {
				if (bingo[i][j] == 0) {
					check++;
				}
			}
			if (check == 5) {
				oneBingo++;
			}
		}
	}

	// 세로
	public static void colBingo() {
		for (int i = 0; i < N; i++) {
			int check = 0;
			for (int j = 0; j < N; j++) {
				if (bingo[j][i] == 0) {
					check++;
				}
			}
			if (check == 5) {
				oneBingo++;
			}
		}
	}

	// 대각선(좌 -> 우)
	public static void LtoRcross() {
		int check = 0;
		for (int i = 0; i < N; i++) {
			if (bingo[i][i] == 0) {
				check++;
			}
		}

		if (check == 5) {
			oneBingo++;
		}
	}

	// 대각선(우 -> 좌)
	public static void RtoLcross() {
		int check = 0;
		for (int i = 0; i < N; i++) {
			if (bingo[i][N-i-1] == 0) {
				check++;
			}
		}

		if (check == 5) {
			oneBingo++;
		}
	}
}
