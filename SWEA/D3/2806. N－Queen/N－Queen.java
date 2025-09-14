import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N, ans;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
			map = new int[N];

			queen(0);
			System.out.println("#" + t + " " + ans);
		}

	}

	static void queen(int row) {
		if (row == N) {
			ans++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if (check(row, c)) {
				map[row] = c;
				queen(row + 1);
			}
		}

	}

	private static boolean check(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (map[i] == col || row - i == Math.abs(col - map[i]))
				return false;
		}
		return true;
	}

}
