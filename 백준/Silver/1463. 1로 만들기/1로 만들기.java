import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		System.out.println(makeOne(N));

	}

	public static int makeOne(int N) {
		int[] dp = new int[N + 1];

		// 1인 경우에 계산 필요 없음
		dp[1] = 0;
			

		for (int i = 2; i <= N; i++) {
			int MIN = dp[i - 1] + 1;
			if (i % 2 == 0)
				MIN = Math.min(MIN, dp[i / 2] + 1);
			if (i % 3 == 0)
				MIN = Math.min(MIN, dp[i / 3] + 1);
			dp[i] = MIN;
		}
		
		return dp[N];

	}

}
