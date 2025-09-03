import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr, sel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		sel = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		comb(0, 0);

	}

	static void comb(int idx, int cnt) {
		if (cnt == M) {
			for(int n : sel) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}

		if (idx == N)
			return;

		sel[cnt] = arr[idx];
		comb(idx + 1, cnt + 1);
		comb(idx + 1, cnt);
		
	}

}
