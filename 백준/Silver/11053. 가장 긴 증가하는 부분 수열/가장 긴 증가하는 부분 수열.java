
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] dp = new int[N];

		int cnt = 0;
		
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			cnt = Math.max(cnt, dp[i]);

		}

		System.out.println(cnt);

	}

}
