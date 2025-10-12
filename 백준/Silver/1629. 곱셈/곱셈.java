import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 모듈러 연산을 이용해서 푸는 것~!!
//(A x B)mod C = ((A mod C) x (B mod C)) mod C

public class Main {

	static long A, B, C;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(solve(A,B,C));

	}

	static long solve(long A, long B, long C) {

		// 기저 조건 : 지수가 0일시 1리턴
		if (B == 0)
			return 1;

		long half = solve(A, B / 2, C);

		// 모듈러 연산
		long modular = (half * half) % C;

		// 지수를 나눈 값이 홀수인 경우
		if (B % 2 == 1)
			modular = (modular * A) % C;

		return modular;

	}

}
