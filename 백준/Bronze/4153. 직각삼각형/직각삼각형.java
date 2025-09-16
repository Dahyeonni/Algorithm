import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == 0 & b == 0 && c == 0)
				break;

			String ans = check(a, b, c) ? "right" : "wrong";

			System.out.println(ans);

		}

	}

	static boolean check(int a, int b, int c) {
		// 가장 긴 변이 대각선
		int[] arr = new int[] { a, b, c };

		Arrays.sort(arr);

		if (arr[2] * arr[2] == arr[0] * arr[0] + arr[1] * arr[1])
			return true;
		return false;
	}

}
