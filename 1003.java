import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// N값이 적어서 먼저 계산
		int[][] dp = new int[41][2]; // [n][0] = 0이 호출되는 횟수, [n][1] = 1이 호출되는 횟수
		dp[0][0] = 1; // fibonacci(0)일 때 0이 1번 호출
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1; // fibonacci(1)일 때 1이 1번 호출

		for (int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}

		// 테스트 케이스 처리
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	}
}
