import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		List<String> arr = new ArrayList<>(set);

		Collections.sort(arr, (a, b) -> {
			if (a.length() == b.length()) {
				return a.compareTo(b);
			}
			return a.length() - b.length();

		});

		for (String s : arr) {
			System.out.println(s);
		}

	}

}
