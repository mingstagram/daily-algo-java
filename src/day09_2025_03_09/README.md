# 📅 2025-03-09 - 일곱 난쟁이 (백준 2309)

- 문제 링크: [https://www.acmicpc.net/problem/2309](https://www.acmicpc.net/problem/2309)
- 난이도: 브론즈 1
- 알고리즘 분류: 브루트포스

---

## 📌 문제 요약

- 9명 중 2명을 제외한 7명의 키의 합이 100이 되도록 하라

---

## 🔍 접근 방식

- 총합을 구하고, 2명을 빼서 100이 되는 조합을 찾음
- 나머지 7명 출력

---

## 💡 배운 점 / 회고

- 브루트포스의 기본 형태 문제
- 조건을 잘 분석하면 복잡하지 않게 풀 수 있음

---

## 💻 코드

```java
package day09_2025_03_09;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        loop:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j)
                            System.out.println(arr[k]);
                    }
                    break loop;
                }
            }
        }
    }
}

```
