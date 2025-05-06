package No43_boj_1260;

import java.util.*;

public class Main {

    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
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

        for(int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);
        visited = new boolean[n + 1];
        System.out.println();
        bfs(v);


    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");;

        for(int next : graph[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for(int next : graph[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

    }

}
