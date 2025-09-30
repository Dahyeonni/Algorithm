import java.util.Scanner;

public class Main {
	// 왼위 오위 왼아 우아

	static int R, C;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();

		int size = (int) Math.pow(2, N);
		visit(0, 0, size, 0);

	}

	static void visit(int r, int c, int size, int cnt) {
		// 기저조건
		if (size == 1) {
			System.out.println(cnt);
			return;
		}

		int half = size / 2;
		int skip = half * half; // 사분면 한변의 길이
		// 1사분면
		if (R < r + half && C < c + half) {
			visit(r, c, half, cnt);
			// 2사분면
		} else if (R < r + half && C >= c + half) {
			visit(r, c + half, half, cnt + skip);
			// 3사분면
		} else if (R >= r + half && C < c + half) {
			visit(r + half, c, half, cnt + (2 * skip));
			// 4사분면
		} else {
			visit(r + half, c + half, half, cnt + (3 * skip));
		}

	}

}
