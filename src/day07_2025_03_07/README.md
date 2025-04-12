# 📅 2025-03-07 - 단어 공부 (백준 1157)

- 문제 링크: [https://www.acmicpc.net/problem/1157](https://www.acmicpc.net/problem/1157)
- 난이도: 브론즈 1
- 알고리즘 분류: 구현, 문자열

---

## 📌 문제 요약

- 입력된 단어에서 가장 많이 등장한 알파벳(대소문자 구분 X)을 출력
- 단, 여러 개일 경우 '?' 출력

---

## 🔍 접근 방식

- 대소문자 구분 없이 처리하기 위해 `.toUpperCase()` 사용
- 알파벳 빈도를 `int[26]` 배열로 카운팅
- 최대 빈도수와 그에 해당하는 알파벳을 찾음

---

## 💡 배운 점 / 회고

- 알파벳 빈도 구하는 방식 연습
- 대문자 처리 및 `char` ↔ `int` 변환 익숙해짐

---

## 💻 코드

```java
package day07_2025_03_07;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }

        int max = -1;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                result = (char) (i + 'A');
            } else if (count[i] == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}

```
