import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int MAX = 100001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dist = new int[MAX];
		Queue<Integer> q = new LinkedList<>();

		q.offer(N);
		dist[N] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == K) {
				System.out.println(dist[now] - 1);
				return;
			}

			for (int next : new int[]{now - 1, now + 1, now * 2}) {
				if (next >= 0 && next < MAX && dist[next] == 0) {
					dist[next] = dist[now] + 1;
					q.offer(next);
				}
			}
		}
	}
}
