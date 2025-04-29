# 📅 스택 (백준 10828)

- 문제 링크: [https://www.acmicpc.net/problem/10828](https://www.acmicpc.net/problem/10828)
- 난이도: 실버 4
- 알고리즘 분류: 자료구조, 스택

---

## 📌 문제 요약

- 스택 자료구조를 직접 구현하는 문제.
- 명령어 종류: `push X`, `pop`, `size`, `empty`, `top`.

---

## 🔍 접근 방식

- `push` 명령은 스택에 추가.
- `pop` 명령은 가장 위에 있는 수를 제거하고 출력.
- `top` 명령은 가장 위에 있는 수 출력(제거는 X).
- 스택이 비었을 경우 `pop`이나 `top` 호출 시 -1 출력.

---

## 💡 배운 점 / 회고

- 기본적인 스택 동작을 다시 점검할 수 있었음.
- `BufferedReader`와 `StringBuilder`를 사용해 대량 입출력에 대응하는 연습이 됨.
- 예외 처리(스택 비었을 때)를 신경 써야 함을 느꼈음.

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
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push")) {
                stack.push(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            } else if (command.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("top")) {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
