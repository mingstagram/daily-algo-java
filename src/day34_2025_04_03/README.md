# 📅 2025-04-03 - 스택 (백준 10828)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/10828](https://www.acmicpc.net/problem/10828)
- 난이도: 실버 4
- 알고리즘 분류: 자료 구조, 스택, 구현

---

## 📌 문제 요약

- 명령어(push, pop, size, empty, top)를 수행하는 스택 구현 문제
- 명령의 결과를 출력해야 하며, 스택이 비어 있는 경우에 대한 예외 처리가 필요함

---

## 🔍 접근 방식

- `Stack` 클래스를 사용할 수도 있지만, 직접 배열과 포인터로 구현하면 더 직관적
- 명령어 입력을 파싱하여 조건에 맞게 처리
- 출력이 많으므로 `StringBuilder`를 활용해 한 번에 출력

---

## 💡 배운 점 / 회고

- 스택의 기본 동작을 명확하게 구현하고, 비어 있을 때의 조건 분기가 중요
- `Scanner.nextLine()`과 `split()`을 적절히 활용하여 명령어 파싱 처리 가능
- 문제를 통해 스택의 원리와 사용 패턴을 복습하기에 적합한 문제

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 제거

        int[] stack = new int[10000];
        int size = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            if (command.startsWith("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                stack[size++] = value;
            } else if (command.equals("pop")) {
                if (size == 0) sb.append(-1).append("\n");
                else sb.append(stack[--size]).append("\n");
            } else if (command.equals("size")) {
                sb.append(size).append("\n");
            } else if (command.equals("empty")) {
                sb.append(size == 0 ? 1 : 0).append("\n");
            } else if (command.equals("top")) {
                if (size == 0) sb.append(-1).append("\n");
                else sb.append(stack[size - 1]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
