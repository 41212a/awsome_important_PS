package g5_1717_집합의표현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_rank {
	// rank를 적용한 것
	
	static int[] numbers, rank;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		numbers = new int[n+1];
		rank = new int[n+1];
		
		init();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int inst = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			
			if (inst == 1) {
				if (find(a) == find(b)) sb.append("YES");
				else sb.append("NO");
				sb.append('\n');
			}
			else
				union(a,b);
			
		}
		System.out.println(sb);
		
	}
	
	public static void init() {
		for (int i = 1; i < numbers.length; i++)
			numbers[i] = i; 
	}
	
	public static void union(int a, int b) {
		a = find(a); // a의 부모를 찾는다
		b = find(b); // b의 부모를 찾는다
		
		if (a==b) // 둘의 부모가 같을 경우, union을 종료한다
			return;
		
		// Union by rank
		// rank가 더 높은 쪽에 낮은 쪽을 합친다
		if (rank[a] < rank[b]) numbers[a] = b;
		else if (rank[a] >= rank[b]) numbers[b] = a;
		
		if (rank[a] == rank[b])
			rank[a]++; // 같은 랭크 r을 가지는 두 트리가 합쳐질 경우 r+1의 트리가 만들어진다.
	}
	
	public static int find(int num) {
		if (numbers[num] == num) // 만약 자신의 값이 자기 자신일 경우, 즉 대표자(루트)일 경우 이를 리턴
			return num;
		
		return numbers[num] = find(numbers[num]); // 모든 경로의 값을 대표자(루트) 한다
	}
}
