

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			
			// 종료조건
			if (str.equals("."))
				break; 

			Stack<Character> stack = new Stack<>();
			boolean isOk = true;

			for (char c : str.toCharArray()) {
				switch (c) { 
				case '(':
				case '[':
					stack.push(c);
					break;

				case ')':
					if (stack.isEmpty() || stack.peek() != '(')
						isOk = false;
					else
						stack.pop();

					break;

				case ']':
					if (stack.isEmpty() || stack.peek() != '[')
						isOk = false;
					else
						stack.pop();

					break;

				default:
					break;
				} // switch문 종료

				if (!isOk)
					break;
			}

			if (isOk && stack.isEmpty())
				System.out.println("yes");
			else
				System.out.println("no");

		}
	}
}
