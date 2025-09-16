import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {

			int R = sc.nextInt();
			String s = sc.next();
			for (int i = 0; i < s.length(); i++) {

				char c = s.charAt(i);

				sb.append(String.valueOf(c).repeat(R));
			}

			sb.append("\n");

		}
		System.out.println(sb);

	}

}
