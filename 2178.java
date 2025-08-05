import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];

		for(int i=0 ; i<N ; i++) {
			String input = br.readLine();
			for(int j=0 ; j<M ; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}

		System.out.println(bfs(arr,N,M));
	}
	public static int bfs(int[][] arr, int N, int M) {
		int[][] dist = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[]{0, 0});
		visited[0][0] = true;
		dist[0][0] = 1;

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (!visited[nx][ny] && arr[nx][ny] == 1) {
						visited[nx][ny] = true;
						dist[nx][ny] = dist[x][y] + 1;
						queue.offer(new int[]{nx, ny});
					}
				}
			}
		}

		return dist[N-1][M-1];
	}
}
