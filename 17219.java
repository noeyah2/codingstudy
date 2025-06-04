import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1 = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st1.nextToken());
    int M = Integer.parseInt(st1.nextToken());

    Map<String, String> map = new HashMap<>(); // 시간 초과나니까
    
    // 정보 저장
    for (int i = 0; i < N; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
      String key = st2.nextToken();
      String value = st2.nextToken();
      map.put(key, value);
    }

    // 찾기
    for (int i = 0; i < M; i++) {
      String query = br.readLine();
      System.out.println(map.get(query));
    }
  }
}
