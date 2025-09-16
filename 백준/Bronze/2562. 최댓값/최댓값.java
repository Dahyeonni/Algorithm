import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N;
		int max = 0;
		int maxIdx = -1;
		for (int i = 0; i < 9; i++) {
			N = sc.nextInt();

			if (N > max) {
				max = N;
				maxIdx = i;
			}
		}

		System.out.println(max);
		System.out.println(maxIdx + 1);

	}

}
