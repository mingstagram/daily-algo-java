package day45_2025_04_13;

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