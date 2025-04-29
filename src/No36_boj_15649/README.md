# 📅 N과 M (1) (백준 15649)

- 문제 링크: [https://www.acmicpc.net/problem/15649](https://www.acmicpc.net/problem/15649)
- 난이도: 실버 3
- 알고리즘 분류: 백트래킹, 브루트포스, 재귀

---

## 📌 문제 요약

- 1부터 N까지 자연수 중에서 **중복 없이 M개를 고른 모든 순열**을 구하는 문제
- 수열은 **오름차순 정렬 필요 없음**
- 각 수열은 공백으로 구분하여 출력

---

## 🔍 접근 방식

- **DFS + 백트래킹** 방식으로 해결
- 깊이를 `depth`로 두고, `depth == M`일 때 수열을 출력
- 사용한 숫자는 `visited[]`로 체크하고, 재귀가 끝나면 다시 `false`로 복구 (Backtracking)
- 핵심 로직은 **선택 → 방문 표시 → 다음 재귀 → 복구**

---

## 💡 배운 점 / 회고

- 백트래킹 로직의 흐름 (재귀 호출 → 출력 → 복귀 → 복구)을 완전히 익힘
- `visited` 배열과 `selected` 배열의 역할 분리해서 사용하면 문제 풀이가 깔끔해짐
- 순열 문제는 DFS 재귀 깊이와 visited 체크를 기반으로 다양하게 응용 가능
- 한 문제로 DFS + 백트래킹 완전 정복하는 느낌! 다른 N과 M 시리즈도 이어서 풀어보자

---

## 💻 코드

```java 
import java.util.*;

public class Main {

    static int n, m;
    static boolean[] visited;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        selected = new int[m];

        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
