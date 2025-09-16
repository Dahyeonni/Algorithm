import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int blank = 0; blank < N - i; blank++)
				System.out.print(" ");
			for (int star = 0; star < i; star++)
				System.out.print("*");
			System.out.println();
		}
	}

}
