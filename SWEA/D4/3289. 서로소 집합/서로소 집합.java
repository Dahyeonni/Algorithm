import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int m, n;
	static int[] p;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			p = new int[n + 1];
			makeSet(n);

			sb.append("#").append(t).append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int choice = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (choice == 0) {
					union(a, b);
				} else {
					sb.append(findSet(a) == findSet(b) ? 1 : 0);

				}

			}

			sb.append("\n");

		}

		System.out.println(sb);

	}

	static void makeSet(int n) {
		for (int i = 0; i <= n; i++) {
			p[i] = i; // 각 집합 만들기

		}

	}

	static int findSet(int x) {
		if (x == p[x])
			return x;

		return p[x] = findSet(p[x]);
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

}
