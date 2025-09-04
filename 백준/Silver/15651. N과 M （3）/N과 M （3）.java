import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] arr, res;
	static boolean isSelected[];
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
        res = new int[M];
        isSelected = new boolean[N];
        
		for(int i = 0; i < N; i++) 
			arr[i] = i+1;
		
		perm(0);
		System.out.println(sb);

	}
	
	static void perm(int idx) {
		// 기저조건
		if(idx == M) {
		    
		    for (int i = 0; i < M; i++) {
		        sb.append(res[i]).append(' ');
		    }
		    sb.append("\n");
		    return;
		}
		for(int i = 0; i < N; i++) {
			
			res[idx] = arr[i];
			isSelected[i] = true;
			perm(idx+1);
			isSelected[i] = false;
			
		}

	}

}
