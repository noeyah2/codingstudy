import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int cnt = 0;

		while (N > 0) {
			int size = 1 << (N - 1);
			int area = size * size;

			if (r < size && c < size) {
			} else if (r < size && c >= size) {
				cnt += area;
				c -= size;
			} else if (r >= size && c < size) {
				cnt += 2 * area;
				r -= size;
			} else {
				cnt += 3 * area;
				r -= size;
				c -= size;
			}
			N--;
		}
		System.out.println(cnt);
	}
}
