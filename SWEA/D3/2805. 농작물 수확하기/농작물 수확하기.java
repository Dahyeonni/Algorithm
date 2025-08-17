// 농작물 수확하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int profit = 0;
			int midIdx = N / 2;

			for (int i = 0; i < N; i++) {
				char[] farm = br.readLine().toCharArray();

				int width;
				if (i <= midIdx) {
					width = i;
				} else {
					width = N - 1 - i;
				}

				int left = midIdx - width;
				int right = midIdx + width;

				for (int pointer = left; pointer <= right; pointer++) {
					profit += farm[pointer] -'0'; // 문자에서 숫자 변환
				}

			}
			sb.append("#" + (t + 1) + " " + profit + "\n");

		} // 테스트 케이스 종료

		System.out.println(sb);
	}

}
