package d4_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution2 {
 
    static int[][] room, dydx, visit;
    static int[] answer;
    static int a = 0;
    static long bb = 0;
    
    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new FileReader("src/d4_/input.txt"));
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
 
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(bf.readLine());
             
            visit = new int[N + 2][N + 2];
            room = new int[N + 2][N + 2];
            dydx = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
            answer = new int[] { 0, 10000001 };
            int result = 0;
 
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 1; j <= N; j++)
                    room[i][j] = Integer.parseInt(st.nextToken());
            }
 
            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    result = dfs(y, x, 1);
 
                    if (answer[0] < result || (answer[0] == result && answer[1] > room[y][x]))
                        answer = new int[] { result, room[y][x] };
                }
            }
            
            System.out.println("#" + t + " " + answer[1] + " " + answer[0]);
        }
        System.out.println(bb);
    }
 
    public static int dfs(int y, int x, int count) {
         
        for (int i = 0; i < 4; i++) {
        	bb++;
            if (room[y + dydx[i][0]][x + dydx[i][1]] == room[y][x] + 1) {
                if (visit[y + dydx[i][0]][x + dydx[i][1]] > 0) {
                    visit[y][x] = visit[y + dydx[i][0]][x + dydx[i][1]]+1;
                    return visit[y][x];
                }
                
                int result = dfs(y + dydx[i][0], x + dydx[i][1], count + 1);
                visit[y][x] = result - count+1;
                return result;
            }
 
            if (i == 3) {
                visit[y][x] = 1; 
                return count;
            }
        }
        return 0;
    }
}