import java.util.Arrays;
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
		int[] idx = new int[N];

		// N+1 로 유지했다면, 0 자체가 이전 없음이지만,
		// N 으로 했을 시, 첫번째 원소(index = 0)을 가르키는 것인지 아닌지 헷갈림.
		// "이전이 없다인지, 0번째 원소를 가르킨다 인지"
		// 그래서 -1로 초기화하여, 이전 없음 명확히 표시하기
		Arrays.fill(idx, -1);

		int max = 0;
		int maxIdx = -1;

		for (int i = 0; i < N; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
//					dp[i] = Math.max(dp[i], dp[j] + 1);
					dp[i] = dp[j] + 1;
					idx[i] = j;
				}
			}

			if (dp[i] > max) {
				max = dp[i];
				maxIdx = i;
			}

		}
		// 가장 긴 수열의 크기
		System.out.println(max);

		// dp : 1 2 1 3 2 4

		// idx : -1 0 -1 1 0 3

		StringBuilder sb = new StringBuilder();
		int cur = maxIdx;

		while (cur != -1) {
			sb.insert(0, arr[cur] + " ");
			cur = idx[cur];
		}

		System.out.println(sb);

	}

}
