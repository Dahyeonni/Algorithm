import java.util.Scanner;

public class Solution {

	static int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 금액

			sb.append("#").append(t).append("\n");
			for (int i = 0; i < money.length; i++) {
				int cnt = N / money[i];
				N %= money[i];

				if (i > 0)
					sb.append(" ");
				sb.append(cnt);
			}

			sb.append("\n");
		} // 테케 종료
		System.out.println(sb);
	}

}
