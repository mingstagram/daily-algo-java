# 📅 2025-03-24 - 덩치 (백준 7568)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/7568](https://www.acmicpc.net/problem/7568)
- 난이도: 실버 5
- 알고리즘 분류: 구현, 브루트포스

---

## 📌 문제 요약

- N명의 키와 몸무게가 주어질 때, **자신보다 키와 몸무게 모두 큰 사람의 수**를 기준으로 등수를 정함
- 모든 사람의 등수를 출력해야 함

---

## 🔍 접근 방식

- 각 사람마다 다른 사람들과 비교하여 키와 몸무게 모두 큰 사람이 몇 명인지 카운트
- 그 수에 1을 더한 값이 본인의 등수
- 이중 반복문을 이용한 완전탐색 방식으로 해결 가능 (O(N²))

---

## 💡 배운 점 / 회고

- 단순 비교 문제지만 조건이 "둘 다 커야" 하므로 조건문 순서를 정확히 짜야 함
- 브루트포스 문제이므로 로직은 단순하지만, 성능보다 정확한 조건 비교가 중요
- 등수를 계산할 때는 초기값을 1로 설정하는 습관이 필요

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] people = new int[N][2];

        for (int i = 0; i < N; i++) {
            people[i][0] = sc.nextInt(); // weight
            people[i][1] = sc.nextInt(); // height
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
