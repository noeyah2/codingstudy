import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] output;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		output = new int[M];
		repeatcombination(0,1);
	}

	static void repeatcombination(int depth, int start) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for(int num : output) {
				sb.append(num).append(" ");
			}
			System.out.println(sb.toString().trim());
			return;
		}

		for(int i=start; i<=N ; i++) {
			output[depth] = i;
			combination(depth+1, i);
		}
	}
}
