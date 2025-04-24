# 📅 숫자 카드 2 (백준 10816)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/10816](https://www.acmicpc.net/problem/10816)
- 난이도: 실버 4
- 알고리즘 분류: 해시, 정렬, 이분 탐색, 자료구조

---

## 📌 문제 요약

- 숫자 카드 N개가 주어진다.
- 숫자 M개가 주어졌을 때, 각 숫자가 N개의 카드에 **몇 개씩 있는지** 출력하라.
- 수는 -10,000,000 ~ 10,000,000 범위.

---

## 🔍 접근 방식

- **두 가지 방법을 고려함:**
    1. `정렬 + 이분 탐색`을 이용해 개수 세기 (lowerBound, upperBound)
    2. `HashMap`을 이용한 등장 횟수 카운팅 → **선택한 방식**

### ✅ 선택한 이유
- 이 문제는 수의 범위는 크지만, 전체 수의 개수는 최대 50만 개 → `HashMap`으로 충분히 빠르게 처리 가능
- 구현이 이분 탐색보다 훨씬 간단하고 직관적

---

## 💡 배운 점 / 회고

- `getOrDefault()`로 등장 횟수 카운팅할 수 있음
- `HashMap`은 정렬이 필요 없어 속도와 효율에서 장점이 있음
- 실무에서도 자주 사용하는 "빈도수 카운팅" 패턴 연습에 좋은 문제

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            int card = sc.nextInt();
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int item = sc.nextInt();
            sb.append(map.getOrDefault(item, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
