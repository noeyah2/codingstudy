import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i;
		}
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);

		int compressed = 0;
		int[] result = new int[N];
		result[arr[0][1]] = compressed;

		for(int i = 1; i < N; i++) {
			if (arr[i][0] != arr[i - 1][0]) {
				compressed++;
			}
			result[arr[i][1]] = compressed;
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(result[i]).append(' ');
		}
		System.out.println(sb);
	}
}
