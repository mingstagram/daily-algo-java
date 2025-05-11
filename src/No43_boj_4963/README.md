# 📅 섬의 개수 (백준 4963)

- 문제 링크: [https://www.acmicpc.net/problem/4963](https://www.acmicpc.net/problem/4963)
- 난이도: 실버 2
- 알고리즘 분류: 그래프 탐색, DFS, BFS, 2차원 배열

---

## 📌 문제 요약

- 1은 땅, 0은 바다로 이루어진 지도가 주어진다.
- **상하좌우 + 대각선까지 총 8방향**으로 연결된 땅을 하나의 "섬"으로 간주한다.
- 지도 하나당 섬이 몇 개 있는지 세는 문제.
- 입력은 여러 개의 테스트케이스로 구성되며, (0, 0)이 입력되면 종료한다.

---

## 🔍 접근 방식

- 2차원 배열로 지도를 저장
- `visited[][]` 배열을 이용해 이미 탐색한 땅은 재방문하지 않음
- 8방향을 탐색하는 DFS 함수를 만들어, 한 번의 DFS로 하나의 섬을 전부 방문 처리
- 섬을 찾을 때마다 `count++`

---

## 💡 배운 점 / 회고

- 유기농 배추 문제에서 배운 4방향 DFS를 → **8방향으로 확장**한 문제
- 방향 배열을 통해 코드 중복 없이 간결한 DFS 구현이 가능함을 다시 한번 느꼈다
- 조건문에서 `||`와 `&&`의 차이를 실제 디버깅하며 체감함
- 테스트케이스 반복 구조도 잘 익힐 수 있는 문제

---

## 💻 코드

```java 
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int w, h;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt(); // 가로
            h = sc.nextInt(); // 세로

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;

            if (map[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
