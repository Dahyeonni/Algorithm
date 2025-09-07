import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int N, cnt;
	static boolean[] col, diag1, diag2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			cnt = 0;

			col = new boolean[N];
			diag1 = new boolean[N * 2];
			diag2 = new boolean[N * 2];

			dfs(0);

			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}

	static void dfs(int row) {
		// 기저 조건
		if (row == N) {
			cnt++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if (col[c] || diag1[row + c] || diag2[row - c + N])
				continue;

			col[c] = diag1[row + c] = diag2[row - c + N] = true;

			dfs(row + 1);

			col[c] = diag1[row + c] = diag2[row - c + N] = false;
		}
	}

}
