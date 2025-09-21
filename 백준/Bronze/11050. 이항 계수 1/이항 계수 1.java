import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int ans = factorial(N) / (factorial(K) * factorial(N - K));
		System.out.println(ans);
	}

	static int factorial(int N) {
		if (N == 0 || N == 1)
			return 1;

		return N * factorial(N - 1);

	}

}
