# 📅 피보나치 수 2 (백준 2748)

- 문제 링크: [https://www.acmicpc.net/problem/2748](https://www.acmicpc.net/problem/2748)
- 난이도: 브론즈 1
- 알고리즘 분류: 다이나믹 프로그래밍(DP)

---

## 📌 문제 요약

- 입력으로 `n`(0 ≤ n ≤ 90)이 주어짐
- 피보나치 수열의 `n`번째 수를 구하는 문제
- 단, `n`이 90까지 가능하므로 **자료형 주의 필요**

---

## 🔍 접근 방식

1. **재귀 방식은 비효율적**이므로 DP 사용
2. **Bottom-Up 방식**으로 `fibo[0]`부터 `fibo[n]`까지 반복문으로 계산
3. `int`가 아닌 **`long`형 배열** 사용 → `fibo[90]`은 `int` 범위를 초과함

---

## 💡 배운 점 / 회고

- 피보나치 수열은 대표적인 DP 문제로, 점화식을 코드로 자연스럽게 구현하는 연습이 된다.
- 입력 범위가 커질수록 **자료형(int vs long)** 의 중요성을 체감할 수 있었음
- 재귀가 아닌 반복문으로도 점화식을 구현할 수 있다는 점이 명확히 이해됨
- DP 배열은 꼭 `n+1` 크기로 선언해야 인덱스 초과를 방지할 수 있다
- 실전 코딩 테스트에서는 항상 **입력 제한에 따른 자료형 오버플로우를 주의**해야 함

---

## 💻 Java 코드

```java
package No32_boj_2748;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] fibo = new long[N + 1];  // long 자료형 사용
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= N; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        System.out.println(fibo[N]);
    }
}
