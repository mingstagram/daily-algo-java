# 📅 구간 합 구하기 4 (백준 11659)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11659](https://www.acmicpc.net/problem/11659)
- 난이도: 실버 3
- 알고리즘 분류: 누적합(Prefix Sum), 자료구조

---

## 📌 문제 요약

- 정수 N개로 이루어진 수열이 주어짐
- 여러 개의 쿼리 (i, j)에 대해:
    - i번부터 j번까지의 **구간 합**을 빠르게 구하라
- 쿼리는 총 M개가 주어짐

---

## 🔍 접근 방식

- 매 쿼리마다 단순히 i~j까지 더하면 **O(NM)** → 시간 초과
- 따라서 누적합(Prefix Sum) 배열 `s[]`을 생성해 빠르게 처리
- `s[i] = a[1] + a[2] + ... + a[i]`
- 쿼리 (i, j)에 대한 결과는 `s[j] - s[i-1]`로 한 줄 계산 가능
- 시간 복잡도는 `O(N + M)`

---

## 💡 배운 점 / 회고

- 이 문제는 누적합 알고리즘의 대표 예시 중 하나!
- 전체 합을 미리 계산해두면 반복 연산 없이 한 줄 계산 가능
- `s[i] = s[i-1] + a[i]` 형태의 누적합 패턴을 기억해두면 유사 문제에 재활용 가능
- `1-based index`로 풀면 `s[0] = 0`을 기준으로 오프셋 문제를 피할 수 있음

---

## 💻 코드

```java
package No16_boj_11659;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] s = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            s[i] = s[i - 1] + sc.nextInt(); // 누적합 계산
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(s[end] - s[start - 1]); // 구간합 출력
        }
    }
}
