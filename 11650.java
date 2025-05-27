import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][2];

    for (int i=0 ; i<N ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr, (e1, e2) -> {
      if (e1[0] == e2[0]) return e1[1] - e2[1];
      else return e1[0] - e2[0];
    });

    // 출력 확인
    for (int i = 0; i < N; i++) {
      StringBuilder sb = new StringBuilder();
      sb.append(arr[i][0]);
      sb.append(" ");
      sb.append(arr[i][1]);
      String result = sb.toString();
      System.out.println(result);
    }
  }
}
