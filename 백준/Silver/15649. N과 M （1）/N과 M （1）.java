import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] arr, res;
	static boolean isSelected[];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
        res = new int[M];
        isSelected = new boolean[N];
        
		for(int i = 0; i < N; i++) 
			arr[i] = i+1;
		
		perm(0);

	}
	
	static void perm(int idx) {
		// 기저조건
		if(idx == M) {
			for(int n : res) {
				System.out.print(n+ " ");
				
			}
			System.out.println();
			
			return;
		}
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			
			res[idx] = arr[i];
			isSelected[i] = true;
			perm(idx+1);
			isSelected[i] = false;
			
		}

	}

}
