# 📅 2025-04-01 - 숫자 카드 2 (백준 10816)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/10816](https://www.acmicpc.net/problem/10816)
- 난이도: 실버 4
- 알고리즘 분류: 자료 구조, 해시, 이분 탐색, 정렬

---

## 📌 문제 요약

- N개의 숫자 카드가 주어지고, M개의 수에 대해 **각 수가 카드에 몇 개 포함되어 있는지** 출력하는 문제

---

## 🔍 접근 방식

- 숫자 카드의 출현 횟수를 `HashMap`을 통해 저장
- 각 쿼리 숫자에 대해 `map.getOrDefault()`로 개수를 확인하여 출력
- 입력 수가 크기 때문에 입출력은 `Scanner + StringBuilder` 조합으로 처리

---

## 💡 배운 점 / 회고

- "몇 개 있는가?" 문제는 대부분 **HashMap 기반 빈도수 처리**로 간단히 해결 가능
- `getOrDefault()` 메서드를 활용하면 null 체크 없이 깔끔하게 구현할 수 있음
- 정렬이나 이분 탐색 없이도 효율적으로 풀 수 있는 문제 유형 중 하나

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int query = sc.nextInt();
            sb.append(map.getOrDefault(query, 0)).append(" ");
        }

        System.out.println(sb);
    }
}
