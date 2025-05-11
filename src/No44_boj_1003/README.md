# 📅 피보나치 함수 (백준 1003)

- 문제 링크: [https://www.acmicpc.net/problem/1003](https://www.acmicpc.net/problem/1003)
- 난이도: 실버 3
- 알고리즘 분류: 다이나믹 프로그래밍, 메모이제이션

---

## 📌 문제 요약

- `fibonacci(n)`을 호출할 때마다 `0`과 `1`이 각각 몇 번 출력되는지 구하는 문제입니다.
- 예를 들어 `fibonacci(3)` 호출 시, 내부적으로 `fibonacci(1)`과 `fibonacci(0)`이 몇 번 호출되는지를 계산합니다.

---

## 🔍 접근 방식

- 재귀로 풀면 호출이 중복되어 시간 초과 발생
- → **메모이제이션(DP)** 으로 해결해야 함

### ✅ 점화식

```text
dp[n][0] = dp[n-1][0] + dp[n-2][0]
dp[n][1] = dp[n-1][1] + dp[n-2][1]
```
- 즉, `fibonacci(n)`을 호출하면
  - → fibonacci(n-1)과 fibonacci(n-2)가 호출되므로
  - → 각 호출 횟수도 누적되는 구조입니다.

---

## 💡 배운 점 / 회고 

- 피보나치 수열 문제는 재귀보다는 DP로 푸는 게 효율적임을 체감
- 단순히 값을 구하는 것이 아닌, 호출 횟수까지 고려하는 문제를 통해
DP 배열을 2차원으로 구성할 줄 아는 감각을 익힘
- 실무에서도 같은 계산을 반복하지 않도록 캐싱(Memoization)의 중요성을 다시 체감함

---

## 💻 코드

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
```