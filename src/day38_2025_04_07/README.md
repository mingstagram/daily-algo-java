# 📅 2025-04-07 - N과 M (2) (백준 15650)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/15650](https://www.acmicpc.net/problem/15650)
- 난이도: 실버 3
- 알고리즘 분류: 백트래킹

---

## 📌 문제 요약

- 1부터 N까지 자연수 중에서 **중복 없이 M개를 고르되**, 오름차순으로 나열한 모든 조합을 출력하는 문제

---

## 🔍 접근 방식

- **조합(combination)**을 만드는 전형적인 백트래킹 문제
- `start` 인덱스를 이용해 오름차순 조건을 자연스럽게 처리
- 현재 깊이를 기준으로 `result` 배열에 선택한 수를 저장하고, 길이가 M이 되면 출력

---

## 💡 배운 점 / 회고

- 조합에서는 중복을 방지하고 순서를 지키기 위해 반복문의 시작 인덱스를 조절해야 함
- 순열(모든 경우)과 조합(순서 상관 없는 선택)의 차이를 명확히 이해하고 구현하는 연습에 적합함
- 탐색 범위를 제한하는 방식으로 조건을 자연스럽게 만족시킬 수 있음

---

## 💻 코드

```java
import java.util.*;

public class Main {
    static int N, M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];

        dfs(1, 0);
        System.out.print(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            result[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
