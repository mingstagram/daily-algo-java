# 📅 2025-03-22 - 소트인사이드 (백준 1427)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1427](https://www.acmicpc.net/problem/1427)
- 난이도: 실버 5
- 알고리즘 분류: 정렬, 문자열

---

## 📌 문제 요약

- 정수 N이 주어졌을 때, 각 자릿수를 **내림차순**으로 정렬하여 출력

---

## 🔍 접근 방식

- 숫자를 문자열로 받아 각 자릿수를 문자 배열로 분리
- `Arrays.sort()`로 정렬 후 역순으로 출력
- 문자 정렬이므로 정렬 기준은 기본적으로 사전 순이지만, 숫자 문자의 경우 정렬이 잘 작동함

---

## 💡 배운 점 / 회고

- 숫자를 자릿수 단위로 다루고 싶을 때 문자열로 변환하는 방식이 간편하고 효과적
- `Arrays.sort()` 후 역순 출력은 내림차순 구현의 간단한 패턴
- 문자열 처리와 정렬을 동시에 연습할 수 있는 간단한 문제

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] digits = sc.next().toCharArray();

        Arrays.sort(digits);

        for (int i = digits.length - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
    }
}
