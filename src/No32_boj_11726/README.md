# 📅 2×n 타일링 (백준 11726)

- 문제 링크: [https://www.acmicpc.net/problem/11726](https://www.acmicpc.net/problem/11726)
- 난이도: 실버 3
- 알고리즘 분류: 다이나믹 프로그래밍(DP)

---

## 📌 문제 요약

- 2×n 직사각형을 1×2, 2×1 타일로 채우는 경우의 수를 구하라.
- 결과는 10007로 나눈 나머지를 출력해야 함.

---

## 🔍 접근 방식

- 점화식: `dp[i] = dp[i - 1] + dp[i - 2]`
- 초기값: `dp[1] = 1`, `dp[2] = 2`
- 반복문을 이용한 Bottom-Up 방식으로 구현

---

## 💡 배운 점 / 회고

- 문제는 "타일링"이지만, 사실상 **피보나치 수열의 변형**이다.
- `dp[0] = 1` 식으로 시작하면 틀릴 수 있음 → **문제 조건을 기준으로 초기값 설정이 중요**
- 반복문에 `% 10007` 연산을 포함시켜 **오버플로우 방지** 필수!
- 점화식 훈련용으로 적절한 DP 입문 문제

---

## 💻 Java 코드

```java
package No32_boj_11726;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
