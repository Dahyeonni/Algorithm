import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] score = new int[N];

		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
		}

		int M = Integer.MIN_VALUE;
		for (int s : score) {
			M = Math.max(s, M);
		}

		double sum = 0;
		for (double s : score) {
			s = s / M * 100;
			sum += s;
		}

		System.out.println(sum / N);

	}

}
