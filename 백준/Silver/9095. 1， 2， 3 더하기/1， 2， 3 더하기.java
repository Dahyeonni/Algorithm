import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(sumcal(N)).append("\n");
		}

		System.out.println(sb);

	}

	public static int sumcal(int N) {
		// 기저조건
		switch (N) {
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 4;
		}

		int[] dp = new int[N + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		// 마지막이 1, 2, 3
		for (int i = 4; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		
		return dp[N];

	}

}
