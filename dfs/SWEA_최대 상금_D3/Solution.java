package d3_1244_최대상금;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int numberLength;
	static int answer;
	static HashSet<String> visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new FileReader("src/d3_1244_최대상금/input.txt"));
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(bf.readLine());
		for (int c = 1; c <= C; c++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			StringBuilder number = new StringBuilder(st.nextToken());
			visit = new HashSet<>();
			numberLength = number.length();
			answer = 0;
			
			int count = Integer.parseInt(st.nextToken());
			
			dfs(number, count);
			System.out.println("#" + c + " " + answer);
		}
	}
	
	public static void dfs(StringBuilder number, int count) {
		String key = number.toString() + Integer.toString(count);
		if (visit.contains(key))
			return;
		
		if (count == 0) {
			int tempAnswer = calNumber(number);
			answer = answer > tempAnswer ? answer : tempAnswer;
			return;
		}
		visit.add(key);
		
		for (int i = 0; i < numberLength-1; i++) {
			for (int j = i+1; j < numberLength; j++) {
				StringBuilder swapNumber = new StringBuilder(number.toString());
				swapNumber.setCharAt(i, number.charAt(j));
				swapNumber.setCharAt(j, number.charAt(i));
				dfs(swapNumber,  count-1);
				
			}
		}
	}
	
	public static int calNumber(StringBuilder number) {
		int result = 0, count = numberLength;
		for (int i = 0; i < numberLength; i++) {
			result += (number.charAt(i) - '0') * Math.pow(10, --count);
		}
		return result;
	}
}
