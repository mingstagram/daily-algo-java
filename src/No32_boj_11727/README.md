# 📅 2×n 타일링 2 (백준 11727번)

- 문제 링크: [https://www.acmicpc.net/problem/11727](https://www.acmicpc.net/problem/11727)
- 난이도: 🟢 실버 3
- 알고리즘 분류: `DP(동적 프로그래밍)`

---

## 📌 문제 요약

- 크기가 2×n인 직사각형을 1×2, 2×1, 2×2 타일로 채우는 방법의 수를 구하라.
- 방법의 수는 **10007로 나눈 나머지**를 출력해야 한다.

---

## 🔍 접근 방식

### 🔢 점화식 도출

- `dp[n] = dp[n - 1] + 2 * dp[n - 2]`
    - `dp[n-1]`: 마지막에 2×1 타일 하나 세로로 붙인 경우
    - `dp[n-2]`: 마지막에 2×2 정사각형 또는 1×2 타일 두 개를 가로로 붙인 2가지 경우 → 곱하기 2

### 🧠 초기값 설정

- `dp[1] = 1` → 2×1을 채우는 경우 1가지
- `dp[2] = 3` → [2×1 + 2×1], [1×2 + 1×2], [2×2]

---

## 💡 배운 점 / 회고

- 점화식을 직접 유도해보며 규칙을 찾는 연습이 되었다.
- 작은 입력부터 직접 그려보면 DP 문제는 규칙을 금방 찾을 수 있다.
- 오버플로우를 방지하기 위해 중간마다 `% 10007`을 꼭 해줘야 한다는 점도 기억!

---

## 💻 코드

```java
package No32_boj_11727;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
        }

        System.out.println(dp[n]);
    }
}
