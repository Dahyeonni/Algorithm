import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 0;
		int jongmal = 666;
		
		while(true) {
			if(String.valueOf(jongmal).contains("666"))
				cnt++;
			
			if(cnt == N) {
				System.out.println(jongmal);
				break;
			}
			
			jongmal++;
		}
		
		
		
	}

}
