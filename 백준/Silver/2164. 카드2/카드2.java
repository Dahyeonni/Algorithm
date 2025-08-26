import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deque<Integer> card = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			card.offer(i);
		} // 카드 입력 완료
		
	
		
		while(card.size() != 1) {
			card.poll();
			int second = card.poll();
			card.offer(second);
		}
		
		int last = card.peek();
		
		System.out.println(last);
		
		

	}

}
