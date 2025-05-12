# 📅 계단 오르기 (백준 2579)

- 문제 링크: [https://www.acmicpc.net/problem/2579](https://www.acmicpc.net/problem/2579)
- 난이도: 실버 3
- 알고리즘 분류: 다이나믹 프로그래밍 (DP)

---

## 📌 문제 요약

- 계단의 개수 `n`(1 ≤ n ≤ 300)이 주어지고, 각 계단마다 점수가 부여되어 있음
- 한 번에 1칸 또는 2칸씩 오를 수 있음
- **세 계단을 연속해서 밟을 수 없음**
- 마지막 계단은 **반드시 밟아야 함**
- 위 조건을 만족하면서 얻을 수 있는 **최대 점수**를 구하는 문제

---

## 🔍 접근 방식

- `dp[i] = i번째 계단을 밟고 도달했을 때의 최대 점수`로 정의
- 점화식 구성:
    - `dp[i] = max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i])`
        - `i-2 → i`로 올라오는 경우 (2칸 점프)
        - `i-3 → i-1 → i`로 올라오는 경우 (중간에 한 칸 밟고 올라옴)
- 초기값 예외 처리 필요:
    - `n == 1`: `dp[1] = score[1]`
    - `n == 2`: `dp[2] = score[1] + score[2]`
    - `n >= 3`: 점화식에 따라 계산

---

## 💡 배운 점 / 회고

- **상태 정의와 문제 조건이 점화식 구성의 핵심**이라는 걸 체감함
- 연속 3칸 금지 조건 때문에 생각보다 점화식이 단순하진 않았음
- 항상 가능한 경로만 고려해서 효율적으로 계산하는 DP 감각을 익힐 수 있었음
- DP에서는 초기값 예외처리 중요!

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        if (n == 1) {
            dp[1] = score[1];
        } else if (n == 2) {
            dp[1] = score[1];
            dp[2] = score[1] + score[2];
        } else {
            dp[1] = score[1];
            dp[2] = score[1] + score[2];
            dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(
                        dp[i - 2] + score[i],
                        dp[i - 3] + score[i - 1] + score[i]
                );
            }
        }

        System.out.println(dp[n]);
    }
}
