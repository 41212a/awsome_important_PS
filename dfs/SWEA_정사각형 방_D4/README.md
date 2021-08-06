# 문제

SWEA 사이트의 **D4** 난이도 1861번 문제인 **정사각형의 방**이다.

Solution.java는 단순 반복문, Solution2.java는 재귀를 사용하였다.
두 코드의 총 `for`문 반복 횟수(입출력 제외)는  `404935` 회로 동일 하다.

[문제보기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE&problemTitle=%EC%A0%95%EC%82%AC&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)

## 요약
- 문제 파악 및 구현에 시간이 오래걸려서 다시 풀고 싶음

##   접근 방식


### *Solution 1*

**재귀**로 접근 하였다. 재귀를 실행할 메서드로 `dfs(int y, int x, int count)` 를 선언하고, 모든 인덱스 마다 해당 메서드를 호출하였다.  

메서드 내부에서는 모든 방향을 탐색한 후, 자신 보다 1 큰 값을 찾는다. 해당 값에 방문한 적이 있을 경우 코스트를 기록하고 종료, 아니면 재귀를 수행한다. 이 후 최대 깊이에 도달하면 깊이를`return` 하여 각각의 메서드 호출 내에서 자신의 코스트를 기록할 수 있도록 한다.


### *Solution 2*
위와 동일한 동작을 수행하나, 재귀가 아닌 단순 `for`문 반복을 사용하는 접근 방식으로 풀었다.



## 이 문제를 기록하는 이유
처음에 **DFS** 로 접근하였으나, 문제가 잘 이해 되지 않고 cost를 기록하는 과정에서 시간이 많이 소요되어, 문제를 제대로 이해하지 못하고 리턴 값을 변경하며 풀어냈다.

이 후 해당 문제는 **반드시 한 방향**(현재보다 숫자가 1 큰 방향)으로만 움직일 수 있어  **재귀**를 사용하지 않고도 풀 수 있다고 생각하여 반복문으로 접근하였으나, 이미 푼 문제임에도 불구하고 또 다시 cost를 기록하는 과정에서 문제가 생겨 이를 해결하는 데 거의 4시간이 걸렸다.

따라서 해당 문제 유형에 대한 이해도를 익히기 위하여 기록하며, 이 문제는 2주 뒤인 `2021-08-20`에 다시 풀 예정이다.