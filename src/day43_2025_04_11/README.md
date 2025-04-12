# 📅 2025-04-11 - 문자열 집합 (백준 14425)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/14425](https://www.acmicpc.net/problem/14425)
- 난이도: 실버 3
- 알고리즘 분류: 자료 구조, 문자열, 해시

---

## 📌 문제 요약

- 문자열로 구성된 집합 S가 주어지고, 문자열 M개가 추가로 주어졌을 때,
- 이들 중 S에 포함된 문자열의 개수를 구하는 문제

---

## 🔍 접근 방식

- 문자열 집합 S를 `HashSet`으로 구성해 포함 여부를 빠르게 확인
- `contains()` 메서드를 이용해 각 문자열이 집합에 있는지 판단
- 평균 시간복잡도 O(1)로 효율적인 탐색 가능

---

## 💡 배운 점 / 회고

- 특정 문자열이 포함되었는지를 빠르게 검사할 때는 `HashSet`이 가장 적합
- 리스트나 배열로 구현 시 O(N) 탐색이 필요하므로 시간 초과가 발생할 수 있음
- 입력 문자열이 많을 때는 빠른 탐색과 출력 방식 선택이 핵심

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // 개행 제거

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String query = sc.nextLine();
            if (set.contains(query)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
