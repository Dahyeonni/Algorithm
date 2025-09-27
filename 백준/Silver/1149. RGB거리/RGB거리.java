// i -1, i + 1 이 과 달라야 한다 -> 너무 헷갈림 -> 즉 전에꺼랑 달라야 함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] dp;
	static int[][] receipt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1][3];
		receipt = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				receipt[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료

		int ans = minCost(N, receipt);
		System.out.println(ans);

	}

	static int minCost(int N, int[][] receipt) {
		dp[1][0] = receipt[1][0]; // R
		dp[1][1] = receipt[1][1]; // G
		dp[1][2] = receipt[1][2]; // B

		for (int i = 2; i <= N; i++) {
			dp[i][0] = receipt[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]); // R
			dp[i][1] = receipt[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]); // G
			dp[i][2] = receipt[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]); // B

		}

		return Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));

	}

}
