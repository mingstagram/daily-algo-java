# 📅 2025-03-26 - ROT13 (백준 11655)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11655](https://www.acmicpc.net/problem/11655)
- 난이도: 실버 5
- 알고리즘 분류: 구현, 문자열

---

## 📌 문제 요약

- 알파벳을 ROT13 방식으로 암호화한 결과를 출력하는 문제
- ROT13: 알파벳을 13글자씩 밀어 변환 (A → N, a → n 등)
- 알파벳이 아닌 글자는 그대로 출력

---

## 🔍 접근 방식

- 입력 문자열의 각 문자를 확인하며 알파벳인 경우 13글자 뒤 문자로 치환
- 'A'~'Z', 'a'~'z' 구간을 나누어 처리
- 13글자 넘어서면 다시 앞쪽으로 순환 (알파벳 26개 기준으로 `% 26` 활용 가능)
- 알파벳이 아닌 문자는 그대로 유지

---

## 💡 배운 점 / 회고

- 아스키코드 기반 문자 치환 문제는 `char` 타입 연산으로 간단히 해결 가능
- 문자 치환 로직에서 경계 조건('Z'를 넘어갈 때 등)을 정확히 처리하는 것이 중요
- ROT13은 대소문자를 구분하여 따로 처리해야 하며, ASCII 코드 계산을 명확히 해야 함

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' + 13) % 26 + 'A');
            } else if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a' + 13) % 26 + 'a');
            }
            sb.append(c);
        }

        System.out.println(sb);
    }
}
