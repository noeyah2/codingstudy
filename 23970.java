// https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-23970-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%88%98%EC%97%85-%EB%B2%84%EB%B8%94-%EC%A0%95%EB%A0%AC-3-java
// 참고할 사이트

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException{

//    선언

    int N;
    int[] arr;
    int[] ans;

//    입력

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    arr = new int[N];
    ans = new int[N];

    StringTokenizer st1 = new StringTokenizer(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());

    for(int i=0 ; i<N ; i++){
      arr[i] = Integer.parseInt(st1.nextToken());
      ans[i] = Integer.parseInt(st2.nextToken());
    }

    if(Arrays.equals(arr, ans)){
      System.out.println(1);
      return;
    }

//    버블 정렬
    boolean matched = false;

    outer:
    for(int i=0 ; i<N-1 ; i++){
      for(int j=0 ; j<N-1-i ; j++){
        if (arr[j] > arr[j + 1]) {
          int tmp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = tmp;
          if(Arrays.equals(arr, ans)){
            System.out.println(1);
            matched = true;
            break outer;
          }
        }
      }
    }
    if(!matched){
      System.out.println(0);
    }
  }
}
