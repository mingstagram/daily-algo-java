# 📅 2025-03-31 - 수 찾기 (백준 1920)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1920](https://www.acmicpc.net/problem/1920)
- 난이도: 실버 4
- 알고리즘 분류: 정렬, 이분 탐색

---

## 📌 문제 요약

- N개의 정수 집합 A가 주어지고, M개의 정수에 대해 각각 A에 존재하는지 확인하여 결과를 출력하는 문제

---

## 🔍 접근 방식

- 탐색 효율을 위해 집합 A를 정렬
- 각 쿼리에 대해 이분 탐색으로 존재 여부를 판단
- Java의 `Arrays.binarySearch()` 메서드를 활용하면 간결하게 구현 가능

---

## 💡 배운 점 / 회고

- 단순한 탐색 문제도 입력 개수가 많으면 선형 탐색보다 **이분 탐색**이 필수적
- 정렬 + 이분 탐색 조합은 탐색 효율을 크게 높일 수 있는 기본 전략
- Java 내장 메서드인 `binarySearch()`를 적절히 활용하면 코드가 간단해짐

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            if (Arrays.binarySearch(A, target) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
