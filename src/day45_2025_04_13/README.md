# 📅 2025-04-13 - 바이러스 (백준 2606)

- 문제 링크: [https://www.acmicpc.net/problem/2606](https://www.acmicpc.net/problem/2606)
- 난이도: 실버 3
- 알고리즘 분류: 그래프 탐색, DFS, BFS

---

## 📌 문제 요약

- 1번 컴퓨터가 바이러스에 걸렸을 때, **1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터 수**를 구하는 문제
- 입력으로 컴퓨터 수와 쌍으로 연결된 네트워크 정보가 주어짐
- **간선은 양방향**
- 1번 컴퓨터를 시작점으로 하여 **연결된 모든 컴퓨터 수 - 1**을 출력

---

## 🔍 접근 방식

- **그래프 형태**로 인접 리스트를 구성
- 1번 노드에서 **DFS 또는 BFS**로 탐색을 시작
- 방문한 노드를 카운트하고, **1번 컴퓨터는 제외하고 출력**
- 중복 방문 방지를 위해 **visited 배열**을 사용

---

## 💡 배운 점 / 회고

- 간단한 **연결 요소 탐색 문제**로 DFS/BFS 기본기 연습에 적합
- 연결이 양방향이라는 점에서 **양방향 리스트 구성**이 중요
- 정점 번호가 1부터 시작하는 경우, 배열 사이즈는 `N + 1`로 잡는 것이 안정적

---

## 💻 코드 (DFS 방식)

```java 
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 컴퓨터 수
        int m = sc.nextInt(); // 연결된 쌍의 수

        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a); // 양방향 연결
        }

        dfs(1); // 1번 컴퓨터에서 시작
        System.out.println(count - 1); // 자기 자신 제외
    }

    static void dfs(int node) {
        visited[node] = true;
        count++;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
