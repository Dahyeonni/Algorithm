import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		System.out.println(solve(n));

	}

	static int solve(int n) {
		dp = new int[n + 1];
		dp[1] = 1;

		if (n >= 2)
			dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		return dp[n];

	}

}
