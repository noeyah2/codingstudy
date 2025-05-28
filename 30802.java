import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[6];
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    for(int i=0 ; i<6 ; i++){
      arr[i] = Integer.parseInt(st1.nextToken());
    }

    StringTokenizer st2 = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st2.nextToken());
    int P = Integer.parseInt(st2.nextToken());

//    티셔츠 수 구하기
    int tshirtTotal = 0;
    for (int i = 0; i < 6; i++) {
      tshirtTotal += (arr[i] + T - 1) / T;
    }
    System.out.println(tshirtTotal);

//    펜 수 구하기
    int penPerPerson = N / P;
    int leftoverPens = N % P;
    System.out.println(penPerPerson + " " + leftoverPens);
  }
}
