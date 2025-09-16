import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] size = new int[6];
		for (int i = 0; i < 6; i++)
			size[i] = sc.nextInt();

		int T = sc.nextInt(); // 티셔츠 묶음
		int P = sc.nextInt(); // 펜 묶음

		int TshirtAns = 0;
		for (int s : size) {
			TshirtAns += (int) Math.ceil((double) s / T);
		}
		System.out.println(TshirtAns);

		System.out.println((N / P) + " " + (N % P));

	}

}
