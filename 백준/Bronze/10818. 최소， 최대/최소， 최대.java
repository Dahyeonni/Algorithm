import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int a;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			a = sc.nextInt();

			if (a > max) {
				max = a; 
			}
			if (a < min) {
				min = a;
			}
		}

		System.out.print(min + " " + max);

	}

}
