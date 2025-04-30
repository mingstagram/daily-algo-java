package No37_boj_15650;

import java.util.*;

public class Main {

    static int n, m;
    static boolean[] visited;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        selected = new int[m];

        dfs(0, 1);

    }

    static void dfs(int depth, int start) {
        if (depth == m) {
            for(int num : selected) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= n; i++) {
            selected[depth] = i;
            dfs(depth + 1, i + 1);

        }

    }

}
