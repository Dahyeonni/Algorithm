import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[] data;
	static int[] sel;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		data = new int[N];
		sel = new int[M];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			data[i] = i + 1;
		}

		// 순열
		perm(0);
		System.out.println(sb);
	}

	static void perm(int idx) {
		if (idx == M) {
			for (int s : sel) {
				sb.append(s).append(" ");

			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {

			if (!visited[i]) {
				sel[idx] = data[i];
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}

		}
	}

}
