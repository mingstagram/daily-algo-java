# 📅 2025-03-02 - 문자열 반복 (백준 2675)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/2675](https://www.acmicpc.net/problem/2675)
- 난이도: 브론즈 2
- 알고리즘 분류: 구현, 문자열

---

## 📌 문제 요약

- 테스트 케이스 `T`개가 주어진다.
- 각 케이스마다 정수 `R`과 문자열 `S`가 주어진다.
- 문자열 `S`의 각 문자를 `R`번 반복한 새 문자열을 출력한다.

---

## 🔍 접근 방식

- 문자열을 `charArray()`로 순회하면서 각 문자를 `R`번 반복
- `StringBuilder`를 활용하면 성능과 코드 가독성에 유리
- `.repeat()` 또는 중첩 `for`문으로 구현 가능

---

## 💡 배운 점 / 회고

- 단어 개수 문제에서 단순히 `split(" ")`만 하면 ` `처럼 공백만 있는 입력을 제대로 처리하지 못할 수 있음
- 자바에서는 문자열의 공백 처리 시 `trim()` + `split()` + `filter()` 조합이 매우 중요
- `filter(s -> !s.isEmpty())`는 연속된 공백 처리 시 유용하다

---

## 💻 코드

```java
package day03_2025_03_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        long count = Arrays.stream(S.trim().split(" "))
                           .filter(s -> !s.isEmpty())
                           .count();
        System.out.println(count);
    }
}

