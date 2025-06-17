# 📅 카드2 (백준 2164)

- 문제 링크: [https://www.acmicpc.net/problem/2164](https://www.acmicpc.net/problem/2164)
- 난이도: 🟢 실버4
- 알고리즘 분류: 자료구조, 큐

---

## 📌 문제 요약

- 1번부터 N번까지 번호가 붙은 카드가 순서대로 큐에 있음
- 다음 과정을 반복함
    1. 제일 위 카드를 버림
    2. 그 다음 제일 위 카드를 맨 아래로 옮김
- 마지막에 남는 카드 번호를 출력

---

## 🔍 접근 방식

- `Queue<Integer>`를 사용하여 1부터 N까지 삽입
- 큐의 크기가 1이 될 때까지 다음을 반복
    - `poll()`로 제일 위 카드 제거
    - 다시 `poll()` 후 `offer()`로 맨 뒤에 삽입
- 마지막에 남은 값을 출력

---

## 💡 배운 점 / 회고

- 큐의 기본 동작을 연습할 수 있는 단순하지만 중요한 문제였습니다.
- `poll()`과 `offer()`를 통해 큐의 앞과 뒤를 다루는 방식에 익숙해졌습니다.
- 입력이 많아질 경우 `BufferedReader`로 리팩토링할 필요도 체감했습니다.

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();                
            queue.offer(queue.poll());   
        }

        System.out.println(queue.poll());  
    }
}