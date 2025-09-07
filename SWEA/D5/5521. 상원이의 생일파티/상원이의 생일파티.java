import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int N, M;
	static List<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();

			adj = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a].add(b);
				adj[b].add(a);
			}
			
			visited = new boolean[N+1];
			
			dfs(1,0);

            int cnt = 0;
            for (int i = 2; i <= N; i++) { 
                if (visited[i]) cnt++;
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);

	}
	
	static void dfs(int idx, int depth) {
		if(depth > 2) return;
		
		for(int n : adj[idx]) {
			if(depth + 1 <= 2) visited[n] = true;
			
			dfs(n, depth+1);
		}
	}

}
