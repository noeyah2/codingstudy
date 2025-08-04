import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		long maxLen = 0;

		for(int i=0 ; i<K ; i++){
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] > maxLen) maxLen = arr[i];
		}

		long start = 1;
		long end = maxLen;
		long result = 0;

		while(start <= end) {
			long mid = (start + end) / 2;
			long cnt = 0;

			for(int i=0 ; i<K ; i++) {
				cnt += arr[i] / mid;
			}

			if(cnt >= N) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}
}
