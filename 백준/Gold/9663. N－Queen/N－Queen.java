import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, cnt;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		cnt = 0;
		map = new int[N];

		queen(0);
		System.out.println(cnt);

	}

	static void queen(int row) {

		if (row == N) {
			cnt++;
			return;
		}

		for (int col = 0; col < N; col++) {
			if (check(row, col)) {
				map[row] = col;
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
