package s2_11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] parrent = new int[N+1];
		
		ArrayList<ArrayList<Integer>> connect = new ArrayList<>(N+1);
		
		for (int i = 0; i < N+1; i++)
			connect.add(new ArrayList<Integer>());
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer strT = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(strT.nextToken());
			int n2 = Integer.parseInt(strT.nextToken());
			
			connect.get(n1).add(n2);
			connect.get(n2).add(n1);
		}
		
		dfs(parrent, connect, N, 1);
		
		for (int i = 2; i < N+1; i++)
			System.out.println(parrent[i]);
	}
	
	public static void dfs(int[] parrent, ArrayList<ArrayList<Integer>> connect, int N, int curNode) {
		for (Integer node : connect.get(curNode)) {
			if (parrent[node] == 0) {
				parrent[node] = curNode;
				dfs(parrent, connect, N, node);
			}
		}
	}
}
