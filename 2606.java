import java.io.*;
import java.util.*;
public class Main {

  static int N,M;
  static int graph[][];
  static boolean[] visited;
  static int cnt = 0;

  static void bfs(int node){
    Queue<Integer> queue = new LinkedList<>();
    visited[node] = true;
    queue.offer(node);

    while(!queue.isEmpty()){
      int current = queue.poll();

      for(int i=1 ; i<=N ; i++){
        if(graph[current][i] == 1 && !visited[i]){
          visited[i] = true;
          cnt++;
          queue.offer(i);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    graph = new int[N+1][N+1];
    visited = new boolean[N+1];

    for(int i=0 ; i<M ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u][v] = graph[v][u] = 1;
    }

    bfs(1);
    System.out.println(cnt);
  }
}
