import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 0 으로 시작하지 않음 -> 1자리수 일 경우 1밖에 없네?
		// 11 을 부분 문자열로 갖지 않음 -> 제한이 있을듯
		// DP인가?
		long[] dp = new long[N+1];
		
		//1
		if(N >= 1) dp[1] = 1;
		//10
		if(N >= 2) dp[2] = 1;
		// 10 + 0 or 1
		// 100 + 0 or 1 101 + 0 
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N]);
		
	}

}
