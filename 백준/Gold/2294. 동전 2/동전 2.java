import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 2294 어렵다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동전 개수
        int K = Integer.parseInt(st.nextToken()); // 목표

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int INF = 10001;  
        int[] dp = new int[K + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int curr : coins) {
            for (int i = curr; i <= K; i++) {
                dp[i] = Math.min(dp[i], dp[i - curr] + 1);
            }
        }

        System.out.println(dp[K] == INF ? -1 : dp[K]);
    }
}