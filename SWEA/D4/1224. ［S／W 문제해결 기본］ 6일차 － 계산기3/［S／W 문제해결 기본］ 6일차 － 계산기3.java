import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			Map<Character, Integer> priority = new HashMap<>();
			priority.put('*', 2);
			priority.put('/', 2);
			priority.put('+', 1);
			priority.put('-', 1);
			priority.put('(', 0);

			String str = br.readLine();

			StringBuilder postfix = new StringBuilder();

			Stack<Character> op = new Stack<>();

			for (int i = 0; i < str.length(); i++) {
				char tmp = str.charAt(i);

				if (tmp >= '0' && tmp <= '9') {
					postfix.append(tmp);
				} else if (tmp == '(') {
					op.push(tmp);
				} else if (tmp == ')') {
					while (op.peek() != '(') {
						postfix.append(op.pop());
					}
					op.pop();
				} else {
					if (op.isEmpty()) {
						op.push(tmp);
					} else {
						while (priority.get(op.peek()) >= priority.get(tmp)) {
							postfix.append(op.pop());
						}
						op.push(tmp);

					}
				}

			}

			while (!op.isEmpty()) {
				postfix.append(op.pop());
			}

			Stack<Integer> calc = new Stack<>();

			for (int i = 0; i < postfix.length(); i++) {
				if (postfix.charAt(i) >= '0' && postfix.charAt(i) <= '9') {

					calc.push(postfix.charAt(i) - '0');
				}

				else {

					int B = calc.pop();
					int A = calc.pop();

					switch (postfix.charAt(i)) {
					case '+':
						calc.push(A + B);
						break;
					case '-':
						calc.push(A - B);
						break;
					case '*':
						calc.push(A * B);
						break;
					case '/':
						calc.push(A / B);
						break;
					}
				}

			}
			System.out.println("#" + tc + " " + calc.pop());
		}

	}

}
