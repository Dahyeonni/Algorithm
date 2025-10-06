import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] sel;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		sel = new int[M];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		perm(0);

	}

	static void perm(int cnt) {
		// 기저조건
		if (cnt == M) {

			for (int num : sel)
				System.out.print(num + " ");
			
			System.out.println();

			return;

		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[cnt] = arr[i];
				perm(cnt + 1);
				visited[i] = false;
			}
		}

	}

}
