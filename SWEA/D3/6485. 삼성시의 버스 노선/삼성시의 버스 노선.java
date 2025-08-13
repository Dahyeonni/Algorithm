import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			int stop[] = new int[5001];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				for(int j = A; j < B+1; j++) {
					stop[j]++;
				}
				
			} // N개 반복 종료
			
			int P = Integer.parseInt(br.readLine());
			
			sb.append("#").append(t+1).append(" ");
			
			for(int p = 0; p < P; p++) {
				int C =  Integer.parseInt(br.readLine());
				sb.append(stop[C]).append(" ");
			}
			sb.append("\n");
			
		}// 테스트 케이스 종료
		
		System.out.println(sb);
	}
}