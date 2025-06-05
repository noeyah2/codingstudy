import java.io.*;
import java.util.*;
public class Main {

  static int N,M,V;
  static int graph[][];
  static boolean[] visited;

  static void dfs(int node){
    visited[node] = true;
    System.out.print(node + " ");

    for (int i = 1; i <= N; i++) {
      if (graph[node][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }

  static void bfs(int node){
    Queue<Integer> queue = new LinkedList<>();
    visited[node] = true;
    queue.offer(node);

    while (!queue.isEmpty()) {
      int current = queue.poll();
      System.out.print(current + " ");
      for (int i = 1; i <= N; i++) {
        if (graph[current][i] == 1 && !visited[i]) {
          visited[i] = true;
          queue.offer(i);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    graph = new int[N+1][N+1];
    visited = new boolean[N+1];

    for(int i=0 ; i<M ; i++){
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u][v] = graph[v][u] = 1;
    }

    dfs(V);
    System.out.println();
    visited = new boolean[N + 1]; // visited 초기화
    bfs(V);

  }
}
