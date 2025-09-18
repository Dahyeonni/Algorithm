import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new int[] { sc.nextInt(), sc.nextInt() });

		}

		Collections.sort(list, (a, b) -> {

			if (a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			}

			return Integer.compare(a[0], b[0]);

		});

		for (int[] num : list) {
			sb.append(num[0]).append(" ").append(num[1]).append("\n");
		}

		System.out.println(sb);
	}
}