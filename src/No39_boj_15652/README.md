# 📅 N과 M (4) (백준 15652)

- 문제 링크: [https://www.acmicpc.net/problem/15652](https://www.acmicpc.net/problem/15652)
- 난이도: 실버 3
- 알고리즘 분류: 백트래킹, 브루트포스, 중복 조합

---

## 📌 문제 요약

- 1부터 N까지 자연수 중에서 **중복을 허용하여 M개를 고른 수열**을 모두 출력하는 문제
- 수열은 **오름차순으로만 출력**
- 예: N=3, M=2일 경우 → `1 1`, `1 2`, `1 3`, `2 2`, ...

---

## 🔍 접근 방식

- **중복 조합** 문제이므로 `visited[]`는 필요 없음
- 오름차순만 출력하기 위해 **start 인자**를 사용하여  
  다음 DFS에서 `i` 이상만 선택 가능하게 함
- 핵심은 `dfs(depth, start)` 구조이며,  
  각 자리에서 선택할 수 있는 수를 제한함으로써 불필요한 백트래킹 생략
- 출력 최적화를 위해 `StringBuilder` 사용

---

## 💡 배운 점 / 회고

- 중복 조합 문제는 `dfs(depth, start)` 패턴만 익히면 거의 공식처럼 적용 가능
- `start = i`를 통해 중복은 허용하고, `visited` 없이도 오름차순을 보장할 수 있음
- 15650(조합)과의 차이를 비교해보며, `start = i + 1` vs `start = i` 개념을 정확히 익힘
- 출력 속도 개선을 위해 `System.out.print` 대신 `StringBuilder`를 사용함

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
        dfs(0, 1);
        System.out.println(sb.toString());
    }

    static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            dfs(depth + 1, i); // 중복 허용: start를 그대로 넘긴다
        }
    }
}
