import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		List<int[]> arr = new ArrayList<>();

		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.add(new int[]{start, end});
		}

		arr.sort((a,b) -> {
			if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
			return Integer.compare(a[1], b[1]);
		});

		int lastEnd = 0;

		for(int i=0 ; i<arr.size() ; i++) {
			int start = arr.get(i)[0];
			int end = arr.get(i)[1];

			if(start >= lastEnd) {
				cnt++;
				lastEnd = end;
			}
		}
		System.out.println(cnt);
	}
}
