# 📅 DFS와 BFS (백준 1260)

- 문제 링크: [https://www.acmicpc.net/problem/1260](https://www.acmicpc.net/problem/1260)
- 난이도: 실버 2
- 알고리즘 분류: 그래프 탐색, DFS, BFS

---

## 📌 문제 요약

- N개의 정점과 M개의 간선으로 구성된 무방향 그래프가 주어진다.
- 시작 정점 V에서 **DFS**, **BFS** 순서로 탐색한 결과를 각각 출력하라.
- 단, **정점 번호가 작은 것부터 방문**해야 한다.

---

## 🔍 접근 방식

- 그래프는 인접 리스트(`List<Integer>[]`)로 구성
- `Collections.sort()`를 사용하여 오름차순 방문을 보장
- DFS는 재귀 방식으로 구현
- BFS는 `Queue`를 이용하여 순차적으로 탐색
- 두 탐색 모두 방문 배열(`visited[]`)을 사용하여 중복 방문 방지
- BFS 시작 전에는 DFS에서 사용한 방문 배열을 초기화함

---

## 💡 배운 점 / 회고

- DFS와 BFS의 구조 차이와 사용 시기를 명확히 구분할 수 있었다.
- 재귀와 큐를 활용한 탐색 방식을 비교하면서 각각의 장단점을 체감함
- 정점 번호가 작은 것부터 탐색 조건을 반영하기 위해 **정렬**이 필요한 경우가 있음을 배움
- **탐색 문제에서 입력 정점 번호의 정렬 처리 여부는 반드시 조건을 확인해야 함**을 다시 인지함

---

## 💻 코드

```java 
import java.util.*;

public class Main {

    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점 수
        int m = sc.nextInt(); // 간선 수
        int v = sc.nextInt(); // 시작 정점

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        // 정점 번호가 작은 순서대로 방문하도록 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);
        System.out.println();

        visited = new boolean[n + 1]; // BFS 전 visited 초기화
        bfs(v);
    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
