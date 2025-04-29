# 📅 덱 (백준 10866)

- 문제 링크: [https://www.acmicpc.net/problem/10866](https://www.acmicpc.net/problem/10866)
- 난이도: 실버 4
- 알고리즘 분류: 자료구조, 덱(Deque)

---

## 📌 문제 요약

- 덱(Deque)을 직접 구현하는 문제.
- 명령어 종류: `push_front X`, `push_back X`, `pop_front`, `pop_back`, `size`, `empty`, `front`, `back`.

---

## 🔍 접근 방식

- 양방향으로 삽입/삭제가 가능한 덱 구조를 사용.
- Java에서는 `Deque` 인터페이스를 `LinkedList`로 구현할 수 있음.

---

## 💡 배운 점 / 회고

- 큐와 덱의 차이를 명확히 알게 되었음 (앞/뒤 둘 다 삽입, 삭제 가능).
- 다양한 명령어를 정확히 처리하는 연습이 됨.
- 덱 관련 메서드(addFirst, addLast, pollFirst, pollLast 등)를 자연스럽게 익힐 수 있었음.

---

## 💻 Java 코드

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push_front")) {
                deque.addFirst(Integer.parseInt(command.split(" ")[1]));
            } else if (command.startsWith("push_back")) {
                deque.addLast(Integer.parseInt(command.split(" ")[1]));
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

        System.out.println(sb.toString());
    }
}