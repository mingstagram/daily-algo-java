# 📅 2025-04-12 - DFS와 BFS (백준 1260)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1260](https://www.acmicpc.net/problem/1260)
- 난이도: 실버 2
- 알고리즘 분류: 그래프 탐색, DFS, BFS

---

## 📌 문제 요약

- 그래프가 주어졌을 때, **DFS와 BFS 결과를 각각 출력**하는 문제
- 정점 번호가 작은 것을 먼저 방문해야 함

---

## 🔍 접근 방식

- 인접 리스트 또는 인접 행렬을 사용하여 그래프 구현
- 각 정점에서 탐색 시 정점 번호 순서대로 방문해야 하므로 정렬 필요
- DFS는 재귀, BFS는 큐를 이용해 구현
- 방문 여부를 따로 관리하며, DFS/BFS 시 각각 초기화 필요

---

## 💡 배운 점 / 회고

- 정점 번호가 작은 순서로 방문 → 인접 리스트 정렬이 핵심
- DFS와 BFS 탐색 방식 차이를 직접 비교할 수 있는 대표적인 문제
- 방문 배열을 따로 분리하여 각 탐색마다 독립적으로 사용해야 함

---

## 💻 코드

```java
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.print(sb);
    }

    public static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            sb.append(curr).append(" ");

            for (int next : graph[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
