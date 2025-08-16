// 새로운 불면증 치료법

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt(), t = 0;

		while (t++ < T) {
			int N = sc.nextInt();

			HashSet<Integer> standard = new HashSet<>();
			for (int i = 0; i < 10; i++) {
				standard.add(i);
			}

			int k = 1;
			int curr = 0;

			HashSet<Integer> set = new HashSet<>();
			boolean flag = true;
			while (flag) {
				curr = N * k;
				String s = String.valueOf(curr);

				for (int i = 0; i < s.length(); i++) {
					char ch = s.charAt(i);
					int digit = ch - '0';
					set.add(digit);
				}
				if (set.equals(standard)) {
					flag = false;
				} else {
					k++;
				}

			} // while 반복문 끝
			sb.append("#" + t + " " + curr + "\n");

		} // 테스트 케이스 끝

		System.out.println(sb);

	}

}
