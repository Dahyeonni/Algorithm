import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			Queue<int[]> q = new LinkedList<>();

			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			for (int n = 0; n < N; n++) {
				int prior = sc.nextInt();
				q.add(new int[] { n, prior });
				pq.add(prior);
			}

			int cnt = 0;

			while (!q.isEmpty()) {
				int[] curr = q.poll();
				int currPrior = curr[1]; // 중요도

				if (currPrior == pq.peek()) {
					pq.poll();
					cnt++;

					if (curr[0] == M) {
						sb.append(cnt).append("\n");
						break;
					}
				}

				else
					q.add(curr);

			}

		}

		System.out.println(sb);

	}

}
