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

- 반복 문자열 처리 방식 연습에 좋았음
- Java 11 이상에서는 `String.repeat()`으로 더 간결하게 구현 가능
- 기본 로직은 단순하지만, 문자열 조작에 익숙해질 수 있는 문제

---

## 💻 코드

```java
package day02_2025_03_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int i = 0; i < T; i++) {
            int R = sc.nextInt();
            String S = sc.next();
            StringBuilder sb = new StringBuilder();

            for (char c : S.toCharArray()) {
                sb.append(String.valueOf(c).repeat(R));
            }

            System.out.println(sb);
        }
    }
}
