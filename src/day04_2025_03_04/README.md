# 📅 2025-03-04 - 음계 (백준 2920)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/2920](https://www.acmicpc.net/problem/2920)
- 난이도: 브론즈 2
- 알고리즘 분류: 구현, 문자열, 배열

---

## 📌 문제 요약

- 8개의 숫자가 입력으로 주어진다.
- 1부터 8까지 오름차순이면 "ascending"
- 8부터 1까지 내림차순이면 "descending"
- 둘 다 아니면 "mixed" 출력

---

## 🔍 접근 방식

- 배열에 입력값 저장
- 1부터 8까지 순서대로 비교 → 오름차순 확인
- 8부터 1까지 순서대로 비교 → 내림차순 확인
- 둘 다 아니면 mixed

---

## 💡 배운 점 / 회고

- 배열 순서 체크 연습에 좋음
- `for`문을 활용한 간단한 조건 확인 문제

---

## 💻 코드

```java
package day04_2025_03_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        if (isAscending(arr)) System.out.println("ascending");
        else if (isDescending(arr)) System.out.println("descending");
        else System.out.println("mixed");
    }

    private static boolean isAscending(int[] arr) {
        for (int i = 0; i < 8; i++) {
            if (arr[i] != i + 1) return false;
        }
        return true;
    }

    private static boolean isDescending(int[] arr) {
        for (int i = 0; i < 8; i++) {
            if (arr[i] != 8 - i) return false;
        }
        return true;
    }
}

```
