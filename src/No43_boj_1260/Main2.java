package No43_boj_1260;

import java.util.*;

public class Main2 {

    static boolean[] visited;
    static List<List<Integer>> graph;
    static int n, m, v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        visited = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); // 인접 리스트 생성
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(v);


    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for(int next : graph.get(now)) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }

        }
    }
}
