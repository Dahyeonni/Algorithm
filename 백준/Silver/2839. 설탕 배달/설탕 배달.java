import java.util.Scanner;

public class Main {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		System.out.println(sugar(N));
	}

	public static int sugar(int N) {

		int cnt = 0;

		while (N >= 0) {
			if (N % 5 == 0) {
				cnt += N / 5;
				return cnt;
			}
			N -= 3;
			cnt++;
		}

		return -1;
	}

}
