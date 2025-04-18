# 📅 2025-04-18 - 덩치 (백준 7568)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/7568](https://www.acmicpc.net/problem/7568)
- 난이도: 실버 5
- 알고리즘 분류: 구현, 브루트포스

---

## 📌 문제 요약

- 사람 수 N이 주어진다.
- 각 사람의 몸무게와 키가 주어진다.
- **자기보다 몸무게와 키가 모두 큰 사람이 몇 명인지** 센다.
- 등수는 **그 수 + 1**로 정의한다.
- 모든 사람의 등수를 출력한다.

---

## 🔍 접근 방식

- `int[][]` 배열로 사람들의 몸무게와 키를 저장한다.
- 모든 사람을 이중 for문으로 비교하면서,
  자신보다 **몸무게도 크고 키도 큰 사람 수를 카운트**한다.
- 등수는 `1 + 카운트`로 바로 출력한다.

---

## 💡 배운 점 / 회고

- 덩치 비교는 단순히 합산하거나 점수화하면 안 되고,
  **문제 조건대로 “둘 다 커야”만 비교가 성립된다는 걸 다시 인지**하게 되었다.
- 문제를 어렵게 꼬아 푸는 것보다, 문제의 정의대로 단순하게 접근하는 게 가장 빠르고 정확하다는 걸 체감했다.
- `if (a < b && c < d)` 같은 복합 조건이 있을 때는 꼭 **직관적 테스트 케이스로 검증**해보는 습관을 가져야겠다.

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt(); // weight
            arr[i][1] = sc.nextInt(); // height
        }

        for(int i = 0; i < N; i++) {
            int rank = 1;
            for(int j = 0; j < N; j++) {
                if (i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
