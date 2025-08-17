// 두개의 숫자열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int A[] = new int[N];
			int B[] = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {

				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {

				B[j] = Integer.parseInt(st.nextToken());
			}

			int L[];
			int S[];

			// 길이 긴 것 정하는 코드
			if (M >= N) {
				L = B;
				S = A;
			} else {
				L = A;
				S = B;
			}

			int gap = L.length - S.length + 1;
			int MAX = Integer.MIN_VALUE;

			int width = S.length;

			for (int i = 0; i < gap; i++) {
				int sum = 0;
				for (int j = 0; j < width; j++) {
					sum += S[j] * L[j + i];
				}
				MAX = Math.max(MAX, sum);

			}

			sb.append("#" + (t +1)+ " " + MAX + "\n");

		} // 테스트 케이스 끝

		System.out.println(sb);

	}

}
