import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	// 루트 노드가 최솟값인 힙
	// 트리의 가장 끝 위치에 데이터를 삽입

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int X = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < X; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input > 0)
				minHeap.add(input);
			else {
				if (!minHeap.isEmpty())
					sb.append(minHeap.poll());
				else
					sb.append("0");

				sb.append("\n");
			}
		}

		System.out.println(sb);

	}

}
