# 📅 2025-03-17 - 구간 합 구하기 4 (백준 11659)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11659](https://www.acmicpc.net/problem/11659)
- 난이도: 실버 5
- 알고리즘 분류: 누적 합, 자료 구조

---

## 📌 문제 요약

- N개의 수와 M개의 구간이 주어졌을 때, 각 구간에 대한 구간합을 빠르게 구하는 문제
- 구간 [i, j]에 대해 A_i + A_{i+1} + ... + A_j 값을 출력해야 함

---

## 🔍 접근 방식

- 입력받은 수열에 대해 **누적합 배열(prefix sum)**을 먼저 생성
- 누적합을 이용해 [i, j] 구간합을 `S[j] - S[i-1]`로 O(1)에 계산
- M개의 쿼리를 각각 처리하여 출력

---

## 💡 배운 점 / 회고

- 기본적인 누적합 패턴을 확실히 익힐 수 있는 문제
- 누적합 배열을 사용할 경우 반복 계산을 피하고 효율적으로 문제를 해결할 수 있음
- 인덱스가 1부터 시작할 경우 배열 크기를 +1 해주는 습관을 들이는 것도 중요

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] prefixSum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(prefixSum[end] - prefixSum[start - 1]);
        }
    }
}
