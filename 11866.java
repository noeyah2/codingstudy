import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> list = new LinkedList<Integer>();
		for(int i=1; i<=N; i++){
			list.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		int idx = 0;
		while(!list.isEmpty()) {
			idx = (idx + K - 1) % list.size();
			sb.append(list.remove(idx));
			if(!list.isEmpty()) {
				sb.append(", ");
			}
		}

		sb.append(">");
		System.out.println(sb);
	}
}
