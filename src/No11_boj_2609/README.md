# 📅 2025-03-11 - 더하기 사이클 (백준 1110)

- 문제 링크: [https://www.acmicpc.net/problem/1110](https://www.acmicpc.net/problem/1110)
- 난이도: 브론즈 1
- 알고리즘 분류: 수학, 구현, 시뮬레이션

---

## 📌 문제 요약

- 주어진 수 N(0 ≤ N ≤ 99)에 대해, 다음 연산을 반복하여 **처음 수로 돌아올 때까지의 반복 횟수(사이클 길이)**를 구하는 문제
- 연산 방법:
  1. N이 한 자리 수면 앞에 0을 붙여 두 자리 수로 간주
  2. 각 자리의 숫자를 더함
  3. 원래 수의 **일의 자리 숫자 + 합의 일의 자리 숫자**로 새로운 수 생성
- 이렇게 반복하여 다시 원래 수로 돌아오는 데 걸리는 반복 횟수를 구함

---

## 🔍 접근 방식

- 입력을 `current`라는 변수로 저장하고, **처음 입력값과 같아질 때까지 반복**
- 각 반복에서 `current`를 10으로 나눠 **십의 자리(a)** 와 **일의 자리(b)** 를 추출
- `sum = a + b`를 계산하고, 새로운 수는 `(b * 10) + (sum % 10)`
- 처음 입력값과 같아질 때까지 `do-while` 루프로 반복 횟수 `count` 증가

---

## 💡 배운 점 / 회고

- 문자열이 아닌 **정수 자체로 자리수를 나누는 방법** 숙지: `숫자 / 10`, `숫자 % 10`
- **do-while 루프 구조**는 조건과 상관없이 최소 1회 실행이 보장되므로 이 문제에 적합
- 원래 수와 비교하여 사이클 종료를 판단하는 구조 이해

---

## 💻 코드

```java
package day11_2025_03_11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int current = N;
        int count = 0;

        do {
            int a = current / 10; // 십의 자리
            int b = current % 10; // 일의 자리
            int sum = a + b;
            current = (b * 10) + (sum % 10);
            count++;
        } while (current != N);

        System.out.println(count);
    }
}
