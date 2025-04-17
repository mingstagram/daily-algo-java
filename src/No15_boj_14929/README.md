# 📅 귀찮아 (SIB) (백준 14929)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/14929](https://www.acmicpc.net/problem/14929)
- 난이도: 실버 5
- 알고리즘 분류: 수학, 누적합, 구현

---

## 📌 문제 요약

- 정수 N개로 이루어진 수열 `a₁, a₂, ..., aₙ`이 주어진다.
- 모든 `i < j`에 대해서 `a[i] × a[j]`의 총합을 구하는 문제.
- 정확히 일치하는 두 인덱스의 쌍 `(i, j)`만 고려 (i < j)

---

## 🔍 접근 방식

- 브루트포스로 이중 반복문을 돌리면 `O(n²)` → 시간 초과
- 수학적으로 식을 분석하면,
```text
총합 = a₀ × (a₁ + a₂ + ... + aₙ₋₁) + a₁ × (a₂ + ... + aₙ₋₁) + ...
```

- 따라서 전체 합에서 현재 값을 하나씩 빼고 누적 계산하는 방식으로 최적화 가능
- 누적합을 이용하여 `O(n)` 시간복잡도로 해결 가능

---

## 💡 배운 점 / 회고

- 곱셈 쌍 문제에서 `i < j`인 경우는 **누적합 기반 최적화**로 풀 수 있는 대표적인 패턴
- 처음엔 감이 잘 안 잡힐 수 있지만, 수학적으로 풀어보면 반복되는 구조를 캐치할 수 있음
- 브루트포스를 바로 쓰지 않고 **패턴화 시켜 수학적으로 모델링 해보는 습관**이 중요

---

## 💻 코드

```java
package No15_boj_14929;

import java.util.*;

public class Main {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      long[] arr = new long[n];
      long total = 0;

      for (int i = 0; i < n; i++) {
          arr[i] = sc.nextLong();
          total += arr[i];
      }

      long result = 0;
      for (int i = 0; i < n; i++) {
          total -= arr[i];  // 뒤쪽 합
          result += arr[i] * total;
      }

      System.out.println(result);
  }
}
