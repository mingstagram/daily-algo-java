# 📅 2025-03-08 - 일곱 난쟁이 (백준 2309)

- 문제 링크: [https://www.acmicpc.net/problem/2309](https://www.acmicpc.net/problem/2309)
- 난이도: 브론즈 1
- 알고리즘 분류: 브루트포스

---

## 📌 문제 요약

- 9명 중 2명을 뺀 7명의 키의 합이 100이 되는 경우 출력

---

## 🔍 접근 방식

- 모든 조합(i, j)에 대해 2명 제외한 합이 100인지 검사
- 조건 만족 시 나머지 7명 출력

---

## 💡 배운 점 / 회고

- 완전탐색의 좋은 예시
- `break loop`를 통해 이중 루프 탈출하는 방법도 기억할 것

---

## 💻 코드

```java
package day08_2025_03_08;

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
