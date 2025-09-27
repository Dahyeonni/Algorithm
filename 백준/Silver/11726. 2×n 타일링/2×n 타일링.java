import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		// 방법의 수
		dp = new int[N+1];
		
		dp[1] = 1;
		if (N >= 2) dp[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] = dp[i] % 10007;
		}
		
		System.out.println(dp[N]);
		
	}

}
