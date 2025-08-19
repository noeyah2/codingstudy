import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println(1);
			return;
		} else if (n == 2) {
			System.out.println(3);
			return;
		}

		int prev2 = 1;
		int prev1 = 3;
		int cur = 0;

		for(int i=3 ; i<=n ; i++) {
			cur = (prev2 * 2 + prev1) % 10007;
			prev2 = prev1 ;
			prev1 = cur;
		}
		System.out.println(cur);
	}
}
