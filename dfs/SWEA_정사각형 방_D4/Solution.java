package d4_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] room, dydx, cost;
	static int[] answer;
	static int a = 0;
	static long count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader("src/d4_/input.txt"));
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(bf.readLine());
			
			
			cost = new int[N + 2][N+2];
			room = new int[N + 2][N + 2];
			dydx = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
			answer = new int[] { 0, 0 };

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 1; j <= N; j++)
					room[i][j] = Integer.parseInt(st.nextToken());
			}
			

			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= N; x++) {
					int curX = x, curY = y, curCost = 1;
					
					
					for (int i = 0; i < 4; i++) {
						count++;
						cost[curY][curX] = 1;
						
						if (room[curY + dydx[i][0]][curX + dydx[i][1]] == room[curY][curX] + 1) {
							int nextCost = cost[curY + dydx[i][0]][curX + dydx[i][1]];
							if (nextCost > 0) {
								curCost = nextCost +1;
								break;
							}

							curCost++;
							curY += dydx[i][0];
							curX += dydx[i][1];
							i = -1;
							continue;
							
						}
					}
					cost[y][x]= curCost;
					
					if (answer[0] < curCost || (answer[0] == curCost && answer[1] > room[y][x]))
						answer = new int[] { cost[y][x], room[y][x] };
				}
				
			}
			System.out.println("#" + t + " " + answer[1] + " " + answer[0]);
		}
		System.out.println(count);
	}
}
