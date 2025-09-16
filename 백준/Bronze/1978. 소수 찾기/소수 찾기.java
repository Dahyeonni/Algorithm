import java.util.Scanner;

public class Main {
	static int N;
	static boolean[] isPrime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		check(1000);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();

			if (num >= 2 && isPrime[num])
				cnt++;
		}

		System.out.println(cnt);

	}
	
	// 에라토스테네스 체
	static void check(int n) {
		isPrime = new boolean[n + 1];

		// 0 과 1은 소수 아님
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}

		// 아리스토테네스 체
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (!isPrime[i]) // 소수가 아니라면
				continue;
			for (int j = i * i; j <= n; j += i) {
				isPrime[j] = false;
			}
		}

	}

}
