import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] A, tmp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = 1000000;
		A = new int[N];
		tmp = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(0, N - 1);

		System.out.println(A[500000]);
	}
	
	static void mergeSort(int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			
			merge(start, mid, end);
		}
	}

	static void merge(int start, int mid, int end) {
		int L = start;
		int R = mid + 1;

		int idx = start;

		while (L <= mid && R <= end) {
			if (A[L] <= A[R]) {
				tmp[idx] = A[L];
				idx++;
				L++;
			} else {
				tmp[idx++] = A[R++];
			}
		}

		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = A[i];
			}
		} else {
			for(int i = R ; i <= end; i++) {
				tmp[idx++] = A[i];
			}
		}
		
		for(int i = start; i <= end; i++)
			A[i] = tmp[i];

	}

}
