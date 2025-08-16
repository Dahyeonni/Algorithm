// 369 게임

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			String num = String.valueOf(i);
			int cnt = 0;

			for (char ch : num.toCharArray()) {
				if (ch == '3' || ch == '6' || ch == '9') {
					cnt++;
				}
			}

			if (cnt > 0) {
				for (int j = 0; j < cnt; j++) {
					sb.append("-");
				}
			} else {
				sb.append(num);
			}
			sb.append(" ");

		}

		sc.close();
		System.out.println(sb);
	}
	

}
