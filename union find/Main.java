package g5_1717_집합의표현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] numbers;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		numbers = new int[n+1];
		
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
		
		numbers[a] = numbers[b];
	}
	
	public static int find(int num) {
		if (numbers[num] == num) // 만약 자신의 값이 자기 자신일 경우, 즉 대표자(루트)일 경우 이를 리턴
			return num;
		
		return numbers[num] = find(numbers[num]); // 모든 경로의 값을 대표자(루트) 한다
	}
}
