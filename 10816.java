import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Map<Integer, Integer> countMap = new HashMap<>(); // 시간초과 해결 위해

    StringTokenizer st1 = new StringTokenizer(br.readLine());
    for(int i=0 ; i<N ; i++){
      int num = Integer.parseInt(st1.nextToken());
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    int M = Integer.parseInt(br.readLine());

    StringTokenizer st2 = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M; i++) {
      int num = Integer.parseInt(st2.nextToken());
      sb.append(countMap.getOrDefault(num, 0));
      if (i != M - 1) {
        sb.append(" ");
      }
    }

    System.out.println(sb);
  }
}
