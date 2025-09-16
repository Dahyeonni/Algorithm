import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int cmd = sc.nextInt();
		Deque<Integer> q = new ArrayDeque<>();
		for (int t = 0; t < cmd; t++) {
			String s = sc.next();

			switch (s) {
			case "push":
				int x = sc.nextInt(); // 숫자 하나 더
				q.addLast(x);
				break;
			case "pop":
				sb.append(q.isEmpty() ? -1 : q.pollFirst()).append('\n');
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				sb.append(q.isEmpty() ? 1 : 0).append('\n');
				break;
			case "front":
				sb.append(q.isEmpty() ? -1 : q.peekFirst()).append('\n');
				break;
			case "back":
				sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
				break;
			}

		}
		System.out.println(sb);
	}

}
