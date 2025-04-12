# 📅 2025-04-06 - N과 M (1) (백준 15649)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/15649](https://www.acmicpc.net/problem/15649)
- 난이도: 실버 3
- 알고리즘 분류: 백트래킹

---

## 📌 문제 요약

- 1부터 N까지 자연수 중에서 중복 없이 M개를 골라 나열하는 모든 순열을 사전 순으로 출력

---

## 🔍 접근 방식

- 순열을 만드는 전형적인 **백트래킹** 문제
- 방문 여부를 확인하기 위한 `boolean[] visited` 배열을 사용
- 현재까지 선택된 수열을 저장하기 위한 `List` 또는 배열 사용
- 재귀적으로 M개가 완성될 때마다 출력

---

## 💡 배운 점 / 회고

- 백트래킹은 조건을 만족할 때마다 재귀 호출하며, 사용한 원소는 체크하고 해제하는 구조가 핵심
- 출력이 많기 때문에 `StringBuilder`를 사용하면 성능이 개선됨
- 사전 순 출력은 자연스럽게 작은 수부터 탐색하는 구조로 구현됨

---

## 💻 코드

```java
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        result = new int[M];

        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
