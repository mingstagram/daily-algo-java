# 📅 2×n 타일링 (백준 11726)

- 문제 링크: [https://www.acmicpc.net/problem/11726](https://www.acmicpc.net/problem/11726)
- 난이도: 실버 3
- 알고리즘 분류: 다이나믹 프로그래밍(DP)

---

## 📌 문제 요약

- 가로 2칸, 세로 n칸의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 문제
- 타일을 겹치거나 잘라서 사용하지 않으며, **채우는 방법의 수를 10,007로 나눈 나머지**를 출력
- 예: n = 2 → (1×2 + 1×2), (2×1 + 2×1) → 총 2가지

---

## 🔍 접근 방식

- 점화식 기반 **DP 문제**로, 피보나치 수열과 비슷한 구조
- `dp[i]` = `dp[i-1]` + `dp[i-2]`  
  → 이유: 마지막에 1×2 타일을 붙이거나, 2×1 타일을 세로 2개 붙이는 두 경우의 수
- `dp[1] = 1`, `dp[2] = 2`를 초기값으로 설정하고, 3부터 점화식에 따라 계산
- 나머지를 `10007`로 나눠서 저장하면 오버플로우 방지

---

## 💡 배운 점 / 회고

- DP의 기초적인 점화식 설계 훈련에 매우 좋은 문제
- 규칙을 직접 몇 개 세워보면서 `dp[n] = dp[n-1] + dp[n-2]` 패턴을 유추
- 타일링 문제는 자주 등장하는 DP 유형이므로, 유사 문제인 11727(2×n 타일링 2)도 함께 보면 좋음
- 나머지 연산을 누적할 때마다 해주는 습관이 중요하다는 점도 체감함

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001]; // 문제 조건상 n ≤ 1000

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
