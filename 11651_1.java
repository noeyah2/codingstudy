import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] arr = new int[N][2];

    for(int i=0 ; i<N ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr, (o1, o2) -> {
      if(o1[1] == o2[1]) {
        return o1[0] - o2[0];
      }
      return o1[1] - o2[1];
    });

    StringBuilder sb = new StringBuilder();
    for(int i=0 ; i<N ; i++) {
      sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
    }
    System.out.print(sb);
  }
}
