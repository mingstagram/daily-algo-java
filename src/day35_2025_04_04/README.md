# 📅 2025-04-04 - 큐 (백준 10845)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/10845](https://www.acmicpc.net/problem/10845)
- 난이도: 실버 4
- 알고리즘 분류: 자료 구조, 큐, 구현

---

## 📌 문제 요약

- `push`, `pop`, `size`, `empty`, `front`, `back` 명령을 수행하는 큐를 구현하고 결과를 출력하는 문제

---

## 🔍 접근 방식

- 명령을 입력받아 조건에 따라 직접 큐 동작을 구현
- `Queue` 대신 배열과 `front`, `rear` 인덱스를 직접 관리하면 빠르게 구현 가능
- 출력은 `StringBuilder`를 통해 모아서 한 번에 출력

---

## 💡 배운 점 / 회고

- 스택과 유사하지만 방향성과 출력 위치가 다르므로 혼동 주의
- 큐는 `poll()` 시 front에서 제거되며, 마지막 값을 추적하기 위해 별도 변수(backIndex) 사용 가능
- 직접 인덱스를 조작하면 라이브러리보다 더 빠르게 동작함

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 제거

        int[] queue = new int[10000];
        int front = 0;
        int rear = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            if (command.startsWith("push")) {
                int val = Integer.parseInt(command.split(" ")[1]);
                queue[rear++] = val;
            } else if (command.equals("pop")) {
                if (front == rear) sb.append(-1).append("\n");
                else sb.append(queue[front++]).append("\n");
            } else if (command.equals("size")) {
                sb.append(rear - front).append("\n");
            } else if (command.equals("empty")) {
                sb.append(front == rear ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                if (front == rear) sb.append(-1).append("\n");
                else sb.append(queue[front]).append("\n");
            } else if (command.equals("back")) {
                if (front == rear) sb.append(-1).append("\n");
                else sb.append(queue[rear - 1]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
