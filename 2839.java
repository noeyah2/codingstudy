import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N+1];
    int[] defaultdp = {-1, -1, -1, 1, -1, 1, 2, -1};

    if(N<=7){
      System.out.println(defaultdp[N]);
      return;
    }

    for(int i=0 ; i<=7 ; i++){
      dp[i] = defaultdp[i];
    }

    for (int i=8; i<=N; i++) {
      if (dp[i-3] != -1 && dp[i-5] != -1) {
        dp[i] = 1 + Math.min(dp[i-3], dp[i-5]);
      } else if (dp[i-3] != -1) {
        dp[i] = 1 + dp[i-3];
      } else if (dp[i-5] != -1) {
        dp[i] = 1 + dp[i-5];
      } else {
        dp[i] = -1; // 만들 수 없는 경우
      }
    }

    System.out.println(dp[N]);
  }
}
