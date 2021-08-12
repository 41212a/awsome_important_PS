package d3_6808_규영이와인영이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class Solution1 {
      
    static int[] gu, an;
    static boolean[] visited;
    static int win, lose;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
        int T = Integer.parseInt(br.readLine());
          
          
        for (int t = 1; t <= T; t++) {
            win = 0; lose = 0;
            gu = new int[9];
            an = new int[9];
            visited = new boolean[19];
              
            StringTokenizer strT = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                gu[i] =  Integer.parseInt(strT.nextToken());
                visited[gu[i]] = true;
            }
              
            for (int i = 1, k = 0; i < 19; i++) {
                if (visited[i] == false)
                    an[k++] = i;
            }
              
            permutation(0, 0, 0);
            System.out.println("#" + t + " " + win + " " + lose);
              
        }
    }
      
    public static void permutation(int depth, int guSum, int anSum) {
        if (depth == 9) {
            if (guSum > anSum) 
                win++;
            else if (guSum < anSum)
                lose++;
            return;
        }
          
        for (int a : an) {
            if (visited[a] == false) {
                visited[a] = true; 
                if (a < gu[depth])
                    permutation(depth+1, guSum + a + gu[depth], anSum);
                else
                    permutation(depth+1, guSum, anSum + a + gu[depth]);
                visited[a] = false; 
            }
        }
    }
}