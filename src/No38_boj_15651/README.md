# 📅 N과 M (3) (백준 15651)

- 문제 링크: [https://www.acmicpc.net/problem/15651](https://www.acmicpc.net/problem/15651)
- 난이도: 실버 3
- 알고리즘 분류: 백트래킹, 브루트포스, 중복순열

---

## 📌 문제 요약

- 1부터 N까지 자연수 중에서 **중복을 허용하여 M개를 고른 수열**을 모두 출력하는 문제
- 수열은 **사전 순으로 출력**
- 예: N=3, M=2일 경우 → `1 1`, `1 2`, `1 3`, `2 1`, ...

---

## 🔍 접근 방식

- 중복을 허용하므로 **visited 배열은 사용하지 않음**
- 단순히 모든 숫자(1~n)를 **depth마다 선택**하며 DFS 탐색
- 출력 속도 향상을 위해 `StringBuilder` 사용
- 핵심 DFS 호출 구조는 `dfs(depth)`이며, `depth == m`일 때 수열을 출력

---

## 💡 배운 점 / 회고

- 중복 가능한 순열(중복순열)은 visited가 필요 없고, 반복문 범위 제한 없이 모든 경우를 탐색하면 된다
- `StringBuilder`는 코딩테스트 대량 출력에서 반드시 사용해야 한다는 교훈도 함께 얻음
- 순열/조합 문제를 패턴별로 풀다 보니 DFS 구조가 자연스럽게 체득됨

---

## 💻 코드

```java
import java.util.*;

public class Main {

    static int n, m;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        selected = new int[m];
        dfs(0);
        System.out.println(sb.toString());
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            selected[depth] = i;
            dfs(depth + 1);
        }
    }
}
