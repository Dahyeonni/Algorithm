import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;

		while (t++ < T) {
			String line = sc.next();
			int ans = 1;

			for (int i = 0; i < line.length() / 2; i++) {
				if (line.charAt(i) != line.charAt(line.length() - i - 1)) {
					ans = 0;
					break;
				}
			}

			System.out.println("#" + t  + " " + ans);
		}

	}

}
