# 📅 ATM (백준 11399)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11399](https://www.acmicpc.net/problem/11399)
- 난이도: 실버 3
- 알고리즘 분류: 그리디, 정렬

---

## 📌 문제 요약

- N명의 사람이 ATM 앞에 줄 서 있으며, 각각 돈을 인출하는 데 걸리는 시간이 다름.
- 각 사람이 돈을 인출하는 데 걸리는 시간 `Pi`가 주어질 때,
- **각 사람이 기다린 시간의 총합이 최소가 되도록** 줄을 서게 해야 한다.
- 기다린 시간의 총합을 구하라.

---

## 🔍 접근 방식

- 기다리는 시간이 최소가 되려면, **작은 시간부터 먼저 처리**해야 한다.
- 입력된 시간을 오름차순으로 정렬한 뒤,
  각 사람이 기다리는 누적 시간을 구해 모두 더한다.
- 예: `[1, 2, 3, 3, 4]` → `1 + (1+2) + (1+2+3) + ...` 형태의 누적 합을 구하는 방식

---

## 💡 배운 점 / 회고

- 그리디 알고리즘에서 정렬이 중요한 역할을 한다는 걸 다시 느꼈다.
- 누적 합을 활용한 간단한 로직으로도 최적해를 구할 수 있다는 게 인상적이었다.
- 간단한 정렬 + 누적합 로직으로 빠르게 풀 수 있는 효율적인 문제!

---

## 💻 코드

```java
package No29_boj_11399;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int total = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
            total += sum;
        }

        System.out.println(total);
    }
}
