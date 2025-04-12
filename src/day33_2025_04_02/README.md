# 📅 2025-04-02 - 괄호 (백준 9012)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/9012](https://www.acmicpc.net/problem/9012)
- 난이도: 실버 4
- 알고리즘 분류: 자료 구조, 스택, 문자열

---

## 📌 문제 요약

- 여러 개의 괄호 문자열이 주어질 때, 각 문자열이 **올바른 괄호 문자열(VPS)**인지 판단하여 결과를 출력하는 문제

---

## 🔍 접근 방식

- 괄호의 짝을 확인하는 문제는 **스택**을 활용하거나, `count` 변수로 해결 가능
- 여는 괄호가 나오면 증가, 닫는 괄호가 나오면 감소
- 중간에 count가 음수가 되거나, 끝났을 때 0이 아니면 올바르지 않음

---

## 💡 배운 점 / 회고

- 괄호 문제는 **스택 또는 카운터** 방식으로 해결할 수 있으며, 단순 괄호쌍 판별에는 카운터가 효율적
- 조건문 처리 순서에 따라 로직 흐름이 완전히 달라질 수 있으므로 주의 필요
- 단순 구현이지만 디버깅 시 괄호 쌍 조건을 명확히 이해하고 있어야 오류 없이 처리 가능

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 개행 제거

        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            if (isVPS(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isVPS(String str) {
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
                if (count < 0) return false;
            }
        }

        return count == 0;
    }
}
