import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, X, M;
	
	static int[][] Memo;
	static int [] cage, ans;
	
	static int MaxSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			Memo = new int[M][3];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				Memo[i][0] = Integer.parseInt(st.nextToken());
				Memo[i][1] = Integer.parseInt(st.nextToken());
				Memo[i][2] = Integer.parseInt(st.nextToken());
			} // 기록들 입력 완료
			
			cage = new int[N];
			ans = new int[N];
			MaxSum = -1;
			
			dfs(0);

			sb.append("#").append(t).append(" ");
			if(MaxSum != -1) {
				for(int a : ans) {
					sb.append(a).append(" ");
				}
			}else {
				sb.append(-1);
			}
			sb.append("\n");
			
			
		} // 테스트 케이스 끝
		System.out.println(sb);
	}
	
	static void dfs(int idx) {
		// 기저 조건
		if(idx == N) {
			// 확인해주고
			if(check()) {
				int sum = 0;
				for(int c : cage) sum += c;
				
				if(sum > MaxSum || (sum == MaxSum && order(cage, ans))) {
					MaxSum = sum;
					ans = cage.clone();
				}
			}
			
			return;
		}
		
		for(int i = 0; i <= X; i++) {
			cage[idx] = i;
			dfs(idx + 1);
		}
	}
	// 기록과 일치 하는지 확인 
	static boolean check() {
		for(int[] m : Memo) {
			int l = m[0] - 1;
			int r = m[1] - 1;
			int s = m[2];
			
			int sum = 0;
			
			for(int i = l; i <=r; i++) 
				sum+= cage[i];
			
			if(sum != s) return false;
			
		}
		return true;
	}
	
	
	static boolean order(int[] origin, int[] compare) {
		for(int i = 0; i < origin.length; i++) {
			if(origin[i] != compare[i]) 
				return origin[i] < compare[i];
		}
		return false;
	}
	
	
}
