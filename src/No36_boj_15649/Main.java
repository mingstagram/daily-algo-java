package No36_boj_15649;

import java.util.*;

public class Main {

    static int n, m;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        selected = new int[m];
        visited = new boolean[n + 1];
        dfs(0);
    }

    static void dfs(int depth) {
        if(m == depth) {
            for(int i = 0; i < m; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[depth] = i;
                dfs(depth + 1);

                visited[i] = false;
            }
        }

    }
}
