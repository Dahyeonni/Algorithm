import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 일반적인 이진 탐색 vs 경계값 알게된 사실
 * 1) while(left <= right) vs while(left < right)
 * 후자는 [0,N) 구간을 가정
 * 2) int right = arr.length - 1 vs int right = arr.length
 * */
public class Main {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int lowIdx = lower(arr, num);
			int upIdx = upper(arr, num);

			int cnt = upIdx - lowIdx;
			sb.append(cnt).append(" ");

		}

		System.out.println(sb);

	}

	// 이진탐색 활용
	static int lower(int[] arr, int key) {
		int left = 0;
		int right = N;
		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] >= key) // 이상
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}

	static int upper(int[] arr, int key) {
		int left = 0;
		int right = N;
		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] > key) // 초과
				right = mid;
			else
				left = mid + 1;
		}

		return left;
	}

}
