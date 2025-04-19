# 📅 ROT13 (백준 11655)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11655](https://www.acmicpc.net/problem/11655)
- 난이도: 브론즈1
- 알고리즘 분류: 문자열, 구현

---

## 📌 문제 요약

- 알파벳으로 구성된 문자열이 주어졌을 때, **ROT13 암호화**를 수행하라.
- ROT13은 알파벳을 13글자씩 밀어서 변환하는 간단한 치환 암호.
- 알파벳이 아닌 문자(숫자, 공백, 특수문자)는 그대로 출력한다.

---

## 🔍 접근 방식

- 문자열을 `char[]`로 변환하여 문자 하나씩 확인한다.
- `Character.isLetter()`로 알파벳 여부를 판단한다.
- 대문자와 소문자를 구분하여 각각의 기준값(`'A'`, `'a'`)을 사용하여 ROT13 적용:
    - `(char)((c - base + 13) % 26 + base)`
- 알파벳이 아닌 문자는 그대로 `StringBuilder`에 추가한다.

---

## 💡 배운 점 / 회고

- 아스키코드 계산을 통해 대소문자 알파벳을 각각 다르게 처리할 수 있다.
- `% 26` 연산을 통해 z 이후 다시 a로 순환되는 알파벳 순서를 구현할 수 있다.
- `Character` 클래스의 유틸 함수(`isLetter`, `isUpperCase`, `isLowerCase`)는 문자열 문제에서 매우 유용하다.

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                if (Character.isUpperCase(arr[i])) {
                    sb.append((char)((arr[i] - 'A' + 13) % 26 + 'A'));
                } else if (Character.isLowerCase(arr[i])) {
                    sb.append((char)((arr[i] - 'a' + 13) % 26 + 'a'));
                }
            } else {
                sb.append(arr[i]);
            }
        }

        System.out.println(sb.toString());
    }
}
