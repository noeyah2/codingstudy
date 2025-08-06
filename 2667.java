import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int[][] arr;
	static int N;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];

		for(int i=0 ; i<N ; i++) {
			String str = br.readLine();
			for(int j=0 ; j<N ; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		ArrayList<Integer> result = new ArrayList<>();

		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					result.add(cnt);
				}
			}
		}

		Collections.sort(result);
		System.out.println(result.size());
		for(int n : result) {
			System.out.println(n);
		}
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		cnt++;

		for(int i=0 ; i<4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(arr[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
}
