import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 배열 입력 완료

		MaxSum();

		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, dp[N - 1][i]);
		}

		System.out.println(ans);
	}

	static void MaxSum() {
		dp[0][0] = arr[0][0]; // 최상위 노드의 값
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {

				if (j == 0)
					dp[i][j] = arr[i][j] + dp[i - 1][j];

				else if (j == i)
					dp[i][j] = arr[i][j] + dp[i - 1][j - 1];

				else
					dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
			}
		}
	}

}
