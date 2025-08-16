// 공과 잡초

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			char[] ch = sc.next().toCharArray();

			
			int ball = 0;
			
			for(int i = 0; i < ch.length; i++) {
				if( ch[i] == '(') {
					 ball++;
				}
				else if(ch[i] == ')' && i > 0 && ch[i-1] == '|') {
					ball++;
				}
			}// 반복문 끝
			sb.append("#"+ (t+1)+ " "+ ball+ "\n");
			
		}
		System.out.println(sb);

	}

}
