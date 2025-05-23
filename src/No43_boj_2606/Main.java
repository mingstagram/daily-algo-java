package No43_boj_2606;

import java.util.*;

public class Main {

    static boolean[] visited;
    static List<Integer>[] graph;
    static int total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);
        System.out.println(total - 1);

    }

    static void dfs(int node) {
        visited[node] = true;
        total++;

        for(int next : graph[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}
