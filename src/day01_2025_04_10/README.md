# 📅 2025-04-10 - 큐 명령어 구현 (백준 10845)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/10845](https://www.acmicpc.net/problem/10845)
- 난이도: 실버 4
- 알고리즘 분류: 자료구조, 큐, 구현

---

## 📌 문제 요약

- 정수를 저장하는 큐(Queue)를 직접 구현하고 명령어를 처리하는 문제
- 처리할 명령어 종류:
  - `push X`: 정수 X를 큐에 넣는다.
  - `pop`: 큐에서 가장 앞에 있는 정수를 빼고 출력. 큐가 비어있으면 -1 출력
  - `size`: 큐에 들어있는 정수 개수 출력
  - `empty`: 큐가 비어있으면 1, 아니면 0 출력
  - `front`: 큐의 가장 앞 정수 출력. 큐가 비어있으면 -1 출력
  - `back`: 큐의 가장 뒤 정수 출력. 큐가 비어있으면 -1 출력

---

## 🔍 접근 방식

- `Queue<Integer>`(구현체는 `LinkedList`)를 사용하여 큐 연산 구현
- `push` 할 때마다 `last` 값을 갱신하여, 큐의 마지막 값을 기억하도록 처리
- `back()` 연산에서 `queue.peekLast()` 등 `Deque`의 기능을 쓰지 않고, 오직 `Queue` 기반으로 구현
- 출력은 `StringBuilder`에 모아 한 번에 출력

---

## 💡 배운 점 / 회고

- `Deque`를 쓰면 `peekLast()`로 쉽게 처리할 수 있었지만, **Queue만 사용하라는 문제 의도**에 따라 별도 변수 `last`를 사용함
- `push()` 연산 시 마지막 삽입 값을 기억하여 `back()` 처리
- 자료구조 구현 문제는 정직하게 조건문과 자료구조 메서드들을 조합해 푸는 연습이 중요함
- 출력 최적화를 위해 `System.out.println()` 대신 `StringBuilder` 사용하여 성능도 고려

---

## 💻 코드

```java
package day01_2025_04_10;

import java.util.*;

public class Main {

    static Queue<Integer> queue = new LinkedList<>();
    static int last = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            switch (command) {
                case "push":
                    int x = sc.nextInt();
                    push(x);
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    static void push(int x) {
        last = x;
        queue.offer(x);
    }

    static int pop() {
        return queue.isEmpty() ? -1 : queue.poll();
    }

    static int size() {
        return queue.size();
    }

    static int empty() {
        return queue.isEmpty() ? 1 : 0;
    }

    static int front() {
        return queue.isEmpty() ? -1 : queue.peek();
    }

    static int back() {
        return queue.isEmpty() ? -1 : last;
    }
}
