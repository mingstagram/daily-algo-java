# 📅 큐 (백준 10845)

- 문제 링크: [https://www.acmicpc.net/problem/10845](https://www.acmicpc.net/problem/10845)
- 난이도: 실버 4
- 알고리즘 분류: 자료구조, 큐

---

## 📌 문제 요약

- 큐 자료구조를 직접 구현하는 문제.
- 명령어 종류: `push X`, `pop`, `size`, `empty`, `front`, `back`.

---

## 🔍 접근 방식

- `push` 명령은 큐 뒤에 추가.
- `pop` 명령은 큐 앞에서 제거하고 출력.
- `front`, `back` 명령은 각각 큐의 앞, 뒤 값을 출력.
- 큐가 비었을 때 예외 처리 필수.

---

## 💡 배운 점 / 회고

- 큐의 가장 기본적인 동작 흐름을 정확히 익힐 수 있었음.
- `LinkedList`를 활용해 Java에서는 쉽게 큐를 다룰 수 있었음.
- 큐가 비었을 때 -1을 출력하는 예외 처리가 중요했음.

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
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push")) {
                queue.add(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
            } else if (command.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : ((LinkedList<Integer>) queue).peekLast()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}