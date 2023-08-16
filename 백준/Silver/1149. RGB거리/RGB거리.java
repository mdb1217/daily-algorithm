import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int price[][];
	static int memo[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// DP
		int min;
		int N;
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		memo = new int[N + 1][3];
		price = new int[N + 1][3];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				price[i][j] = Integer.parseInt(st.nextToken());
		}
		
		min = Math.min(DP(N, 0), DP(N, 1));
		min = Math.min(min, DP(N, 2));
		System.out.println(min);
	}
	
	static int DP(int house, int color) {
		if(house == 1)
			return price[house][color];
		if(memo[house][color] > 0)
			return memo[house][color];
		else
			memo[house][color] = price[house][color] + Math.min(DP(house - 1, (color + 1) % 3), DP(house - 1, (color + 2) % 3));
		return memo[house][color];
	}
}