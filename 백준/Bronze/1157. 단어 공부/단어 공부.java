import java.util.Scanner;
// 단어 공부 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		char[] ch = sc.next().toUpperCase().toCharArray();
		int alpha [] = new int[26];
		
		for(int c : ch) {
			alpha[c-'A']++;
		}
		
		
		int idx = 0;
		int max = 0;
		boolean bol = false;
		
		for(int i = 0; i < alpha.length; i++) {
			if(alpha[i]>max) {
				max = alpha[i];
				idx = i;
				bol = false;
			}
			else if(max == alpha[i]) {
				bol = true;

			}
			
		}
		
		if(bol) {
			System.out.println("?");
		}else {
			System.out.println((char)(idx+'A'));
		}
		
	}

}
