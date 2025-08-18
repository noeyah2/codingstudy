import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] board;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		int minCnt = Integer.MAX_VALUE;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				minCnt = Math.min(minCnt, checkBoard(i, j));
			}
		}
		System.out.println(minCnt);
	}

	static int checkBoard(int x, int y) {
		int cnt1 = 0, cnt2 = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				char cur = board[x + i][y + j];

				if ((i + j) % 2 == 0) {
					if (cur != 'W') cnt1++;
					if (cur != 'B') cnt2++;
				} else {
					if (cur != 'B') cnt1++;
					if (cur != 'W') cnt2++;
				}
			}
		}
		return Math.min(cnt1, cnt2);
	}
}
