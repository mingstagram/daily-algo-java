# 📅 2025-03-15 - 계단 오르기 (백준 2579)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/2579](https://www.acmicpc.net/problem/2579)
- 난이도: 실버 3
- 알고리즘 분류: 다이나믹 프로그래밍(DP)

---

## 📌 문제 요약

- 계단이 N개 있음. 각 계단마다 점수가 존재하고, 계단을 오를 때마다 해당 점수를 얻음.
- 조건:
    1. 한 번에 한 계단 또는 두 계단씩만 오를 수 있음.
    2. **연속된 세 개의 계단을 밟을 수 없음** (세 번 연속 한 계단씩 올라가는 것은 불가능).
    3. 마지막 계단은 반드시 밟아야 함.

- 목표: **얻을 수 있는 점수의 최댓값**을 구하라.

---

## 🔍 접근 방식

- **DP(동적 계획법)**을 사용하여 각 계단에 도달했을 때의 최대 점수를 저장.
- `dp[i]`를 i번째 계단에 도달했을 때 최대 점수라고 할 때, 점화식은 아래와 같음:

### ✅ 점화식

- `dp[1] = score[1]`
- `dp[2] = score[1] + score[2]`
- `dp[3] = max(score[1] + score[3], score[2] + score[3])`
- `dp[i] = max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i]` (i ≥ 4)

> 이유: i번째 계단에 오르기 위해서
> - i-2번째에서 한 번에 2칸 오르거나
> - i-3번째에서 한 칸 오르고 i-1도 밟고 i로 오는 두 가지 경우만 존재

---

## 💡 배운 점 / 회고

- **"세 계단 연속 불가"** 조건이 있는 경우 → 보통 `dp[i-3]`까지 살펴봐야 함.
- 계단 문제는 일반적으로 `dp[i] = dp[i-1] + dp[i-2]` 류로 생각하기 쉬운데, **추가 조건이 있을 땐 분기 처리를 잘 해야 한다**.
- 예외 처리 없이 **초기값(dp[1], dp[2], dp[3]) 세팅**이 매우 중요함.

---

## 💻 코드

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];

        dp[1] = score[1];
        if (n >= 2) {
            dp[2] = score[1] + score[2];
        }
        if (n >= 3) {
            dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(dp[n]);
    }
}
