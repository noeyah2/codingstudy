import java.io.*;
import java.util.*;
public class Main {

  static boolean[] visited;
  static int[][] graph;

  static void bfs(int start, int N) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      for (int i = 1; i <= N; i++) {
        if (graph[cur][i] == 1 && !visited[i]) {
          visited[i] = true;
          queue.offer(i);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    graph = new int[N + 1][N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u][v] = graph[v][u] = 1;
    }

    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        bfs(i, N);
        cnt++;
      }
    }

    System.out.println(cnt);
  }
}
