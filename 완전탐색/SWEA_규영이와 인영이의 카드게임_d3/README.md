# 문제

SWEA 사이트의 **D3** 난이도 6808번 문제인 **규영이와 인영이의 카드게임**이다.
Solution1은 boolean 배열, Solution2는 비트 마스킹으로 재귀 시 방문을 체크했다.
Solution1 (20432KB, 2758ms)
Solutoon2 (20,132 kb, 1845ms)


[문제보기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0&categoryId=AWgv9va6HnkDFAW0&categoryType=CODE&&&)

## 요약
- visit 배열이 아닌 비트 마스킹으로 순열 접근 방법
- 비트 마스킹이 더 빠르다
```java
//nPr일 때
void permutation(int flag, int depth){
	if (depth == r) // 다 골랐다면 return
		return;
		
	for (int i = 0; i < n; i++) {
				if ((flag & 1<<i) != 0) continue; // i를 이미 골랐다면 continue
				permutation(flag | 1<<i, depth+1); // i를 고르지 않았다면 고르고(i<<1) 재귀
			}
}
```

##   접근 방식

일반적인 순열문제 였다. 심지어 문제에 경우의 수가 9!라고 나와있기 까지 했다.
따라서 nPr (n = 9, r = 9) 순열을 구현만 하면 풀리는 문제였다.

단 규영이가 고르지 않은 카드 중에서만 순열을 돌려야 했는데, 이 또한 범위 및 규영이가 고른 카드가 주어져 처리를 쉽게할 수 있다.

Solution1과 2의 차이점은 1은 `boolean[] visited`, 2는 `int flag`를 사용하여 비트마스킹으로 visit를 체크했는데, 2에서 1의 visited는 다음과 같이 대응된다.
~~~java
// 이미 방문한 숫자를 스킵
if (visited[i] == true) continue; //1
if ( (flag & 1 << i) ~= 0) continue; //2
~~~ 
==> 1에 i번 left shift 연산을 수행 후 기존의 flag와 & 연산을 수행하면, 마치 i번째 자리가 1, 즉 골라져 있느냐고 묻는 것과 같다.

~~~java
// 다음 재귀로 넘어가기
// 1
visited[i] = true;
permutation(visitied);
visited[i] = false;

//2
permutation(flag | 1 << i);
~~~
==> 1 << i 수행 후 flag와 | 연산을 하면 visited[i] = true; 와 같다. (i번째 자리를 1로 바꾸는 연산과 같다)


## 이 문제를 기록하는 이유
Solution1과 Solution2의 차이는 2758ms -> 1845ms로, 비트 마스킹을 사용한 Solution2가 무려 900ms나 빨랐다.
비트 마스킹으로 순열을 돌리는 법을 잘 몰랐기도 했고, 더 효율적이라는 사실도 알게 되었으니 두고두고 기억하고자 이 문제를 기록했다.