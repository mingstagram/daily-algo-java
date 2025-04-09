# 📅 2025-04-08 - 괄호 (백준 9012)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/9012](https://www.acmicpc.net/problem/9012)
- 난이도: 실버 4
- 알고리즘 분류: 자료구조, 스택, 문자열

---

## 📌 문제 요약

- 괄호 문자열이 주어졌을 때, 올바른 괄호(Valid Parenthesis String, VPS)인지 판단하는 문제
- 조건:
    - '('는 push
    - ')'는 pop
    - 중간에 비어있는데 pop하면 invalid
    - 마지막에 stack이 비어 있어야 valid

---

## 🔍 접근 방식

- `Stack<Character>`를 사용하여 '('일 때 push
- ')'일 때 pop 시도
- 만약 pop 전에 stack이 비어 있으면 "NO"
- 반복 후 stack이 비어 있으면 "YES", 아니면 "NO"

---

## 💡 배운 점 / 회고

- 스택 기본 개념 복습에 좋았다
- 문제 자체는 쉬웠지만, 문자열을 순회하면서 조건 판단하는 연습이 됨
- 자바에서는 `stack.isEmpty()` 체크를 자주 써야 함 
- Stack은 괄호의 모양까지 추적할 때 필요하고, Stack 없이 카운터 방식으로도 가능한 점 (메모리 효율)

---

## 💻 코드

```java
package day01_2025_04_08;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean valid = true;

            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) valid = false;
            System.out.println(valid ? "YES" : "NO");
        }
    }
}