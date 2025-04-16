# 📅 2025-03-14 - 비밀번호 발음하기 (백준 4659)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/4659](https://www.acmicpc.net/problem/4659)
- 난이도: 실버 5
- 알고리즘 분류: 문자열, 구현

---

## 📌 문제 요약

- 입력으로 주어지는 문자열이 "좋은 비밀번호"인지 판단해야 함
- 다음 조건을 모두 만족해야 함:
    1. 모음(a, e, i, o, u)을 하나 이상 포함
    2. 모음 혹은 자음이 **3개 이상 연속**으로 오면 안 됨
    3. 같은 글자가 **연속적으로 두 번 오면 안 됨** (단, ee와 oo는 허용)

---

## 🔍 접근 방식

- 각 문자열에 대해 조건을 순차적으로 검사
    - 모음 개수 카운트
    - 연속된 모음/자음 개수 추적
    - 이전 문자와 현재 문자가 같은지 비교 (예외 처리 포함)
- 조건을 모두 만족하면 “acceptable”, 아니면 “not acceptable” 출력
- 입력은 `"end"`가 나올 때까지 반복 처리

---

## 💡 배운 점 / 회고

- 문자열 검사 문제에서 상태(모음/자음 여부, 연속 횟수 등)를 잘 추적하는 것이 핵심
- 조건이 많을수록 if 문 순서를 명확하게 정리하고, 예외 처리를 꼼꼼히 해야 함
- 작은 조건 누락도 오답이 되므로 **예외 조건을 먼저 처리**하는 전략이 유효함

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String password = sc.nextLine();
            if (password.equals("end")) break;

            boolean isAcceptable = true;
            boolean hasVowel = false;
            int vowelCount = 0;
            int consonantCount = 0;
            char prev = 0;

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);

                boolean isVowel = "aeiou".indexOf(c) != -1;

                // 모음 포함 여부
                if (isVowel) hasVowel = true;

                // 연속 모음/자음 체크
                if (isVowel) {
                    vowelCount++;
                    consonantCount = 0;
                } else {
                    consonantCount++;
                    vowelCount = 0;
                }

                if (vowelCount >= 3 || consonantCount >= 3) {
                    isAcceptable = false;
                    break;
                }

                // 같은 글자 연속 체크 (ee, oo는 예외)
                if (i > 0 && c == prev && c != 'e' && c != 'o') {
                    isAcceptable = false;
                    break;
                }

                prev = c;
            }

            if (!hasVowel) isAcceptable = false;

            if (isAcceptable) {
                System.out.println("<" + password + "> is acceptable.");
            } else {
                System.out.println("<" + password + "> is not acceptable.");
            }
        }
    }
}
