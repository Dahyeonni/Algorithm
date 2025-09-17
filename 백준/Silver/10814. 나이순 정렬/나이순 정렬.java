import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		List<String[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new String[] { st.nextToken(), st.nextToken() });
		}
		
		// 내림차순
		list.sort((a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));

		for (String[] member : list) {
			sb.append(member[0]).append(" ").append(member[1]).append("\n");

		}

		System.out.println(sb);

	}

}
