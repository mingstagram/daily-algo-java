# 📅 2025-03-16 - 귀찮아 (SIB) (백준 14929)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/14929](https://www.acmicpc.net/problem/14929)
- 난이도: 실버 5
- 알고리즘 분류: 수학, 누적 합

---

## 📌 문제 요약

- 정수 N개로 이루어진 수열이 주어질 때, 모든 `i < j`에 대해 `Ai × Aj`의 합을 구하는 문제

---

## 🔍 접근 방식

- 이중 반복문을 사용하면 O(N²)로 시간 초과 발생
- 누적합을 이용해 Ai 이후의 합을 계산해 `Ai * (A_{i+1} + A_{i+2} + ... + A_N)`으로 변환
- 각 원소를 기준으로 오른쪽 항의 합과 곱해 전체 합을 구함
- 시간 복잡도는 O(N)으로 최적화 가능

---

## 💡 배운 점 / 회고

- 이중 반복을 줄이기 위해 누적합 또는 전체 합을 활용하는 패턴에 익숙해질 수 있는 문제
- 수학적 전개를 통해 식을 변형하고 시간 복잡도를 개선하는 연습에 적합함
- 문제에서 요구하는 수학적 패턴을 빠르게 캐치하는 것이 중요

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        long sum = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            sum += A[i];
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            sum -= A[i];
            result += (long) A[i] * sum;
        }

        System.out.println(result);
    }
}
