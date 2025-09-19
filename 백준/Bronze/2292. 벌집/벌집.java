import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int floor = 1;
		int lastNum = 1;
		

		while(N > lastNum) {
			lastNum += 6 * floor;
			floor++;
		}
		
		System.out.println(floor);
	}

}
