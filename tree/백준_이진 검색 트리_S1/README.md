# 문제

백준 사이트의 **S1** 난이도 5639번 문제인 **이진 검색 트리**이다.
이진 검색 트리의 전위 순회 결과를 보고 후위 순회 결과를 출력하는 문제이다.

[문제보기](https://www.acmicpc.net/problem/5639)

## 요약
- 입력 종료 시점이 명시되어 있지 않을 땐
~~~java
BufferedReader br = new BufferedReader();
while((str = br.readLine()) != null){
	// 블라블라
}
~~~
- 순회 결과 -> 트리로 바꾸는 것에 대해: ([참고 영상](https://www.youtube.com/watch?v=kGdnFfi2uz8))
  1. 일반적으로 **순회 결과 한 개**로는 안됨
  2. 전위 순회 + 중위 순회 주면 가능
  3. 후위 순회 + 중위 순회도 가능
  4. 전위 순회 + 후위 순회는 **포화 이진 트리**`(leaf를 제외하고 모두 자식이 2개 있는 트리)` 일때만 가능.
  5. 위 내용을 굳이 외울 필요는 없을 듯. 알고만 있자

##   접근 방식

이진 트리이기 때문에 배열로 트리를 구현할 수 있으나, 노드 수가 최대 10,000이기 때문에 배열 크기를 2^10,000개 잡아야 해서 포기했다. 따라서 클래스로 Node를 선언하여 구현했다.


처음엔 전위 순회만 보고 바로 트리로 만드는 생각을 했으나, 경우의 수가 너무 많아 바로 포기했다.

이 후 이진 검색 트리라는 점과 전위 순회라는 특징을 살려 빠르게 트리를 구성하는 법을 찾으려 했다. 큐에 순회 결과를 담아가며 자신 보다 큰 노드를 만났을 경우 큐를 보면서 등등... 그러나 시간, 메모리 측면에서 그냥 주어진 노드로 아예 이진 검색 트리를 만드는게 낫다는 것을 깨달았다.
(이진 검색 트리이기 때문에 삽입에 `O(높이)` 이 걸린다. 이것보다 빠르게 구현할 수는 없겠다고 판단했다.)

따라서 그냥 전위 순회 결과를  일일이 트리에 `insert` 하여 이진 검색 트리를 만들고, 해당 트리를 바탕으로 후위 순회를 수행했다.

## 이 문제를 기록하는 이유
먼저 이 문제는 입력 종료 시점이 딱히 정해져있지 않고, 그저 전위 순회 결과만 여러 줄에 걸쳐 입력 받는 형식이었다. 따라서 **더 이상 입력이 없을 때**를 체크해줄 필요가 있었으며, 코드는 다음과 같다.
~~~java
BufferedReader br = new BufferedReader();
while((str = br.readLine()) != null){
	// 블라블라
}
~~~
위 내용을 보면 신기한 것이 하나 있는데, `str = br.readLine()` 부분이다. 메서드의 반환 값을 변수에 넣어 줌과 동시에 비교를 할 수 있다는 것을 처음 깨달았다.

또한 순회 결과 -> 트리로 바꾸는 것에 대해 좀 더 찾아본 결과, 관련 내용을 이해하기 쉽게 설명한 [영상](https://www.youtube.com/watch?v=kGdnFfi2uz8)을 찾았다. 영상이 13분 이므로 시간 날 때 보는 것도 괜찮을 것 같다.
순회 결과를 트리로 바꾸는 법을 굳이 외울  필요는 없어 보이지만, 트리 순회 자체에 대한 생각의 폭을 넓힐 수 있었던 것 같아 기록하였다.