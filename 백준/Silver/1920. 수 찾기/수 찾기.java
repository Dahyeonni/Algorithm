import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		HashSet<Integer> set = new HashSet<>();
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}

		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			if (set.contains(sc.nextInt())) {
				sb.append(1);
			} else {
				sb.append(0);
			}

			sb.append("\n");
		}

		System.out.println(sb);

	}

}
