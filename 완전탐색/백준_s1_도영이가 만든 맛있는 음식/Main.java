package s1_2961_도영이가만든;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long answer = -1;
		long[][] flavor = new long[N][2];
		
		for (int n = 0; n < N; n++) {
			StringTokenizer strT = new StringTokenizer(br.readLine());
			flavor[n][0] = Integer.parseInt(strT.nextToken());
			flavor[n][1] = Integer.parseInt(strT.nextToken());
		}

		for (int i = 1; i < (1 << N); i++) {
			int S = 1;
			int B = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1<<j)) != 0) {
					
					S *= flavor[j][0];
					B += flavor[j][1];
				}
			}
			if (answer == -1)
				answer = Math.abs(S-B);
			else
				answer = Math.min(answer, Math.abs(S-B));
			
		}
		System.out.println(answer);
	}
}
