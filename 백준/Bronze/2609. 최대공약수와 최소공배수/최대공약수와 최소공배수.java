import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(gcd(A,B));
		System.out.println(lcm(A,B));

	}

	// 최대공약수
	static int gcd(int a, int b) {
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}

	// 최소공배수
	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

}
