import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] classes = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			classes[i][0] = Integer.parseInt(st.nextToken());
			classes[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(classes, (x, y) -> {
			;
			if (x[1] == y[1])
				return x[0] - y[0]; // 끝나는 시간 같을때
			return x[1] - y[1]; // 끝나는 시간 오름차순
		});

		int cnt = 0;
		int end = 0;

		for (int i = 0; i < N; i++) {
			if (classes[i][0] >= end) {
				cnt++;
				end = classes[i][1];
			}
		}

		System.out.println(cnt);

	}

}
