# 📅 2025-03-05 - 유레카 이론 (백준 10448)

- 문제 링크: [https://www.acmicpc.net/problem/10448](https://www.acmicpc.net/problem/10448)
- 난이도: 브론즈 1
- 알고리즘 분류: 브루트포스

---

## 📌 문제 요약

- 정수 `K`가 세 삼각수의 합으로 표현 가능한지 확인하는 문제
- 삼각수: `Tn = n(n+1)/2` 형태

---

## 🔍 접근 방식

- 1부터 45까지의 삼각수를 미리 저장
- 세 개의 삼각수 조합으로 `K`를 표현 가능한지 확인
- 삼중 for문을 사용한 브루트포스

---

## 💡 배운 점 / 회고

- 조합 문제에서 완전탐색으로 접근 가능함을 확인
- 자료를 미리 준비해놓고 탐색하는 방식은 자주 사용됨

---

## 💻 코드

```java
package day05_2025_03_05;

import java.util.*;

public class Main {
    static List<Integer> triangle = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 45; i++) {
            triangle.add(i * (i + 1) / 2);
        }

        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();
            System.out.println(isEureka(K) ? 1 : 0);
        }
    }

    static boolean isEureka(int k) {
        for (int i : triangle)
            for (int j : triangle)
                for (int m : triangle)
                    if (i + j + m == k) return true;
        return false;
    }
}

```
