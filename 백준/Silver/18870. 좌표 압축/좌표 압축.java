import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] ans = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			ans[i] = arr[i];

		}

		Arrays.sort(ans);

		Map<Integer, Integer> map = new HashMap<>();

		int idx = 0;
		for (int i : ans) {
			if (!map.containsKey(i)) {
				map.put(i, idx++);
			}
		}

		for (int a : arr) {
			sb.append(map.get(a)).append(" ");
		}

		System.out.println(sb);
	}

}
