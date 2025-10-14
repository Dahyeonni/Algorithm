import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		// 여기 부분 주의!
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			int A = Math.abs(a);
			int B = Math.abs(b);

			if (A == B)
				return a - b;
			return A - B;
		});

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append("0").append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				pq.add(x);
			}
		}

		System.out.print(sb);
	}

}
