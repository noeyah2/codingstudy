import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Deque<Integer> dq = new ArrayDeque<>();

    for (int i = 1; i <= N; i++) {
      dq.addLast(i);
    }

    while (dq.size() > 1) {
      dq.pollFirst();              // 맨 앞 제거
      dq.addLast(dq.pollFirst());  // 그 다음 맨 뒤로 이동
    }

    System.out.println(dq.peek());
  }
}
