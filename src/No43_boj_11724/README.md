# 📅 연결 요소의 개수 (백준 11724)

- 문제 링크: [https://www.acmicpc.net/problem/11724](https://www.acmicpc.net/problem/11724)
- 난이도: 실버 2
- 알고리즘 분류: 그래프, DFS, BFS

---

## 📌 문제 요약

- 정점의 개수 N과 간선의 개수 M이 주어짐
- 무방향 그래프에서 **연결 요소**의 개수를 구해야 함
- 연결 요소란: **모든 정점이 서로 연결된 부분 그래프**

---

## 🔍 접근 방식

- DFS로 그래프를 탐색하면서, **방문하지 않은 정점이 나올 때마다 DFS를 새로 호출**
- DFS가 한 번 호출될 때마다 **하나의 연결 요소**를 탐색한 것이므로, 호출 횟수를 세면 됨
- 정점 번호가 1부터 시작하므로 배열 크기를 `n + 1`로 설정
- `graph[]`는 인접 리스트로 구성 (무방향)

---

## 💡 배운 점 / 회고

- DFS를 “여러 번 호출”해서 연결된 컴포넌트를 찾는 방식이 확실히 체득됨
- `visited[]`로 이미 방문한 노드는 제외하며 전체 그래프 탐색
- **연결되지 않은 정점**도 잘 처리되었는지 확인하는 습관이 중요
- 연결 요소를 세는 문제는 **전체 탐색 DFS**의 연습에 아주 좋은 문제

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

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++; 
            }
        }

        System.out.println(count);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
