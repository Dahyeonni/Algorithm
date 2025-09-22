import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int pre = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			pre += arr[i];
			sum += pre;
		}

		System.out.println(sum);

	}

}
