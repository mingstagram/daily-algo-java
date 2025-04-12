# 📅 2025-04-05 - 덱 (백준 10866)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/10866](https://www.acmicpc.net/problem/10866)
- 난이도: 실버 4
- 알고리즘 분류: 자료 구조, 덱, 구현

---

## 📌 문제 요약

- `push_front`, `push_back`, `pop_front`, `pop_back`, `size`, `empty`, `front`, `back` 명령을 수행하는 **덱**(Deque)을 구현하는 문제

---

## 🔍 접근 방식

- Java의 `Deque` 또는 `LinkedList`를 활용하면 모든 연산을 O(1)로 처리 가능
- 명령어에 따라 분기 처리하여 `addFirst`, `addLast`, `pollFirst`, `peekLast` 등의 메서드를 사용
- 출력은 `StringBuilder`를 사용해 빠르게 처리

---

## 💡 배운 점 / 회고

- 덱은 양방향 삽입/삭제가 모두 가능한 자료구조로, 다양한 큐 문제에 활용됨
- Java의 `Deque`는 인터페이스이고, `LinkedList`가 실제 구현체로 자주 사용됨
- 명령이 많고 반복되므로 구조적으로 깔끔하게 분기하는 방식이 중요함

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 제거

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            if (command.startsWith("push_front")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(x);
            } else if (command.startsWith("push_back")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                deque.addLast(x);
            } else if (command.equals("pop_front")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            } else if (command.equals("pop_back")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            } else if (command.equals("back")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
