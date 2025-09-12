
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static boolean isSelected[];
	static int arr[];
	static int sel[];
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc = new Scanner(System.in);
		 N = sc.nextInt(); 
		 M = sc.nextInt();
		 
		 arr = new int[N];
		 isSelected = new boolean[N];
		 
		 sel =  new int[M];
		 
		 for(int i = 0 ; i < N; i++) {
			 arr[i] = i + 1;
		 } // 데이터 입력 완료
		 
		perm(0,0);
		System.out.println(sb);
	}
	
	
	static void perm(int idx, int start) {
		
		if(idx == M) {
			for(int i = 0 ; i < M; i++) sb.append(sel[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			sel[idx] = arr[i];                
			perm(idx + 1, i);
		}
	}

}
