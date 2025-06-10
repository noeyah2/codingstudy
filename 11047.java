import java.io.*;
import java.util.*;
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    int cnt = 0;

    for(int i=0 ; i<N ; i++){
      arr[i] = Integer.parseInt(br.readLine());
    }

//    K와 가장 가까운 작은 수를 찾아, K에서 빼기를 반복. K가 0이 될 때까지
    for(int i=N-1 ; i>=0 ; i--){
      if(arr[i] <= K){
        cnt += (K / arr[i]);
        K = K % arr[i];
      }
    }
    System.out.println(cnt);
  }
}
