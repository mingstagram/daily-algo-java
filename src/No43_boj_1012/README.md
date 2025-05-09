# 📅 유기농 배추 (백준 1012)

- 문제 링크: [https://www.acmicpc.net/problem/1012](https://www.acmicpc.net/problem/1012)
- 난이도: 실버 2
- 알고리즘 분류: 그래프 탐색, DFS, BFS

---

## 📌 문제 요약

- 배추밭에 배추가 여러 개 심어져 있음.
- 상하좌우로 인접한 배추는 하나의 무더기로 간주됨.
- 서로 떨어진 배추 무더기마다 **지렁이 1마리**가 필요.
- **필요한 지렁이 수 = 배추 무더기의 개수**를 구하라.

---

## 🔍 접근 방식

- 2차원 배열(`map`)에 배추 위치를 1로 마킹
- `visited[][]`를 이용하여 방문한 배추 체크
- 전체 좌표를 돌면서 **방문하지 않은 배추(1)를 발견하면 DFS 수행**
- DFS는 해당 배추와 연결된 상하좌우 배추를 모두 방문 처리
- DFS가 한 번 호출될 때마다 지렁이 한 마리 → `count++`

---

## 💡 배운 점 / 회고

- 2차원 DFS의 기본 구조를 확실하게 체득함
- map과 visited를 분리하여 관리하는 것이 중요함을 깨달음
- DFS로 연결된 컴포넌트를 완전히 탐색한 뒤 count 증가하는 흐름이 확실히 잡힘
- 입력 시 좌표가 `(x, y)` 순인데 배열은 `[y][x]`임을 주의해야 함
- 4방향 탐색을 위한 `dx[]`, `dy[]` 배열 패턴을 숙지함

---

## 💻 코드

```java 
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int m, n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            m = sc.nextInt(); // 가로 길이
            n = sc.nextInt(); // 세로 길이
            int k = sc.nextInt(); // 배추 개수

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1; // 배추 위치 표시
            }

            int count = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (map[y][x] == 1 && !visited[y][x]) {
                        dfs(x, y);
                        count++; // 지렁이 하나 필요
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

            if (map[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(nx, ny);
            }
        }
    }
}
