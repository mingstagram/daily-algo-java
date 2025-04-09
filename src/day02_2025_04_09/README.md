# 📅 2025-04-09 - 스택 명령어 구현 (백준 10828)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/10828](https://www.acmicpc.net/problem/10828)
- 난이도: 실버 4
- 알고리즘 분류: 자료구조, 스택, 구현

---

## 📌 문제 요약

- 정수를 저장하는 스택을 구현하고 명령어를 처리하는 문제
- 처리할 명령어 종류:
    - `push X`: 정수 X를 스택에 넣는다.
    - `pop`: 스택의 top을 제거하고 출력. 스택이 비어있으면 -1 출력
    - `size`: 스택에 들어있는 정수 개수 출력
    - `empty`: 스택이 비어있으면 1, 아니면 0 출력
    - `top`: 스택의 top에 있는 정수를 출력. 비어있으면 -1 출력

---

## 🔍 접근 방식

- `Stack<Integer>` 자료구조를 사용하여 명령어별 동작을 구현
- 명령어가 `"push"`일 경우 `sc.nextInt()`로 정수를 받아 `stack.push()`
- 그 외 명령어는 `switch-case`로 분기하여 각각에 맞는 동작 수행
- 각 동작 결과는 바로바로 출력

---

## 💡 배운 점 / 회고

- 기본적인 스택 연산들을 명령어로 구현하면서 Stack 사용법 복습
- 명령어별로 적절한 조건 분기를 짜는 연습이 됨
- 자바에서 `Scanner`로 문자열과 숫자를 혼용 입력받을 때 주의할 점 확인
- 문제 수가 많아지면 `BufferedReader` + `StringBuilder` 방식도 고려할 수 있음 (성능 향상용)

---

## 💻 코드

```java
package day02_2025_04_09;
import java.util.*;

public class Main {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            String command = sc.next();
            if(command.equals("push")) {
                int num = sc.nextInt();
                push(num);
            } else {
                switch (command) {
                    case "pop":
                        System.out.println(pop());
                        break;
                    case "size":
                        System.out.println(size());
                        break;
                    case "empty":
                        System.out.println(empty());
                        break;
                    case "top":
                        System.out.println(top());
                        break;
                }
            }
        }
    }

    static void push(int x) {
        stack.push(x);
    }

    static int pop() {
        return stack.isEmpty() ? -1 : stack.pop();
    }

    static int size() {
        return stack.size();
    }

    static int empty() {
        return stack.isEmpty() ? 1 : 0;
    }

    static int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }
}
