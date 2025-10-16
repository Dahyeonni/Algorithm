import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 접근과정
		// 0 으로 시작하지 않음 -> 1자리수 일 경우 1밖에 없네?
		// 11 을 부분 문자열로 갖지 않음 -> 제한이랑 규칙이 있을듯
		// DP인가?

		// 3자리수
		// 10 + 0 or 1

		// 100 + 0 or 1 101 + 0 여기서 1이 안됨
		// 1000 + 0 or 1 1010 + 0 or 1

		// 끝이 0일때랑 1일때랑 경우가 다른거 같다,,

		// dp 재정의 : 그 자리에서 끝이 0 일때랑 1일때
		long[][] dp = new long[N + 1][2];

		dp[1][0] = 0;
		dp[1][1] = 1;

		for (int i = 2; i <= N; i++) {
			// 끝이 0인 경우 : 이전꺼 둘다 가능 1은 그전에 0인것만 가능
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 1][0];
		}

		System.out.println(dp[N][0] + dp[N][1]);

	}

}
