# 📅 2025-03-01 - OX퀴즈 (백준 8958)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/8958](https://www.acmicpc.net/problem/8958)
- 난이도: 브론즈 2
- 알고리즘 분류: 구현, 문자열

---

## 📌 문제 요약

- 여러 개의 OX 문자열이 주어졌을 때, O가 연속되는 횟수만큼 점수를 누적해서 총 점수를 계산하는 문제
- 예를 들어 `OOXXOXXOOO`의 점수는 `1+2+0+0+1+0+0+1+2+3 = 10`

---

## 🔍 접근 방식

- 각 문자열에 대해 문자 하나씩 순회하며 다음과 같이 처리
    - `O`일 경우 `currentScore`를 증가시키고, 총점에 더함
    - `X`일 경우 `currentScore`를 0으로 초기화
- 결과는 테스트 케이스 수만큼 출력

---

## 💡 배운 점 / 회고

- 문자열을 순회하며 누적 값을 계산하는 패턴을 익히기에 좋은 문제
- 단순한 조건 분기지만 "연속성"을 잘 처리해야 함
- 자바에서는 `charAt()`과 `nextLine()`의 입력 흐름을 주의할 것

---

## 💻 코드

```java
package day01_2025_03_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 개행 처리

        for (int i = 0; i < T; i++) {
            String line = sc.nextLine();
            int score = 0;
            int current = 0;

            for (char ch : line.toCharArray()) {
                if (ch == 'O') {
                    current++;
                    score += current;
                } else {
                    current = 0;
                }
            }

            System.out.println(score);
        }
    }
}
