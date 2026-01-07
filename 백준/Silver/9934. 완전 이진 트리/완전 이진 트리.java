import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int K;

	static StringBuilder[] ans;
	static int[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*
		 * 1. 입력(중위 순회): 1 6 4 [3] 5 2 7  (왼 -> 루트 -> 오)
		 * 2. 출력(레벨 별): 3 -> 6 2 -> 1 4 5 7
		 * 3. 아이디어(분할 정복):
		 * - 배열의 '가운데'가 루트가 되고, 좌/우로 나누어 다시 가운데를 찾으면 다음 층의 노드가 됨.
		 * - 이 과정을 재귀를 통해 깊이(K)까지 반복.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		int depth = (1 << K) - 1;

		visit = new int[depth];

		// 배열 입력
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < depth; i++) {
			visit[i] = Integer.parseInt(st.nextToken());
		}

		ans = new StringBuilder[K];

		for (int i = 0; i < K; i++) {
			ans[i] = new StringBuilder();
		}

		solve(0, depth - 1, 0);

		for (int i = 0; i < K; i++) {
			System.out.println(ans[i]);
		}

	}

	static void solve(int start, int end, int level) {

		// 기저 조건
		if (level == K) {
			return;
		}

		int mid = (start + end) / 2;

		ans[level].append(visit[mid]).append(" ");

		// 왼쪽
		solve(start, mid - 1, level + 1);

		// 오른쪽
		solve(mid + 1, end, level + 1);

	}

}
