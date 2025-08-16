import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {

			char[] originBit = sc.next().toCharArray(); // 입력값
			int N = originBit.length;
			char[] resetBit = new char[N];
			for (int i = 0; i < N; i++) { // 초기값
				resetBit[i] = '0';
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (originBit[i] != resetBit[i]) {
					cnt++;
					for (int j = i; j < N; j++) {
						resetBit[j] = originBit[i];

					}
				}
			}

			sb.append("#"+ (t+1) + " "+ cnt+"\n");

		} // 테스트 케이스 끝
		System.out.println(sb);
	}

}
