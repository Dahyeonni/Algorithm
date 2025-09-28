import java.util.Scanner;

public class Main {

    static int N, K;
    static int[] W, V;
    static int[][] dp;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 물품의 수
		K = sc.nextInt(); // 무게

		dp = new int[N + 1][K + 1];

		W = new int[N + 1]; // 무게
		V = new int[N + 1]; // 가치

		for (int i = 1; i <= N; i++) {
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		}
		
		System.out.println(pack(N,K));

	}

	static int pack(int N, int K) {
		for(int i = 1; i <= N; i++) { // 배낭수까지
			
			for(int w = 1; w <= K; w++ ) { // 최대 무게까지
				
				if(W[i] <= w) //임시무게보다 작거나 같다면
					dp[i][w] = Math.max(dp[i-1][w],
							dp[i-1][w-W[i]] + V[i]); //가치 더해주고
				 
				else
					dp[i][w] = dp[i-1][w];
					
			}
			
		}
		
		return dp[N][K];
	}

}
