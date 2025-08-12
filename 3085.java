import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] board;
	static int maxCandy = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (j + 1 < N && board[i][j] != board[i][j + 1]) {
					swap(i, j, i, j + 1);
					checkLine(i, j, j + 1);
					swap(i, j, i, j + 1); // 원상복귀
				}

				if (i + 1 < N && board[i][j] != board[i + 1][j]) {
					swap(i, j, i + 1, j);
					checkLine(j, i, i + 1);
					swap(i, j, i + 1, j); // 원상복귀
				}
			}
		}

		System.out.println(maxCandy);
	}

	static void checkLine(int fixedRowOrCol, int idx1, int idx2) {
		checkRow(fixedRowOrCol);
		checkRow(idx1);
		checkRow(idx2);

		checkCol(fixedRowOrCol);
		checkCol(idx1);
		checkCol(idx2);
	}

	static void checkRow(int r) {
		int count = 1;
		for (int c = 1; c < N; c++) {
			if (board[r][c] == board[r][c - 1]) {
				count++;
			} else {
				count = 1;
			}
			maxCandy = Math.max(maxCandy, count);
		}
	}

	static void checkCol(int c) {
		int count = 1;
		for (int r = 1; r < N; r++) {
			if (board[r][c] == board[r - 1][c]) {
				count++;
			} else {
				count = 1;
			}
			maxCandy = Math.max(maxCandy, count);
		}
	}

	static void swap(int x1, int y1, int x2, int y2) {
		char temp = board[x1][y1];
		board[x1][y1] = board[x2][y2];
		board[x2][y2] = temp;
	}
}
