import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] ch1, ch2;

	static int[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ch1 = br.readLine().toCharArray();
		ch2 = br.readLine().toCharArray();

		dp = new int[ch1.length + 1][ch2.length + 1];

		System.out.println(LCS());

	}

	static int LCS() {

		for (int i = 1; i <= ch1.length; i++) {
			for (int j = 1; j <= ch2.length; j++) {
				if (ch1[i - 1] == ch2[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;

				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[ch1.length][ch2.length];

	}

}
