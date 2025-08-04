import java.io.*;
import java.util.*;

public class Main {
	static int white = 0;
	static int blue = 0;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, N);
		System.out.println(white + " " + blue);
	}

	static void divide(int x, int y, int size) {
		if (checkSame(x, y, size)) {
			if (arr[x][y] == 0) white++;
			else blue++;
			return;
		}

		int newSize = size / 2;
		divide(x, y, newSize); // 왼쪽 위
		divide(x, y + newSize, newSize); // 오른쪽 위
		divide(x + newSize, y, newSize); // 왼쪽 아래
		divide(x + newSize, y + newSize, newSize); // 오른쪽 아래
	}

	static boolean checkSame(int x, int y, int size) {
		int first = arr[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != first) return false;
			}
		}
		return true;
	}
}
