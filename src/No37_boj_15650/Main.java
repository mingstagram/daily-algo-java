package No37_boj_15650;

import java.util.*;

public class Main {

    static int n, m;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        selected = new int[m];

        dfs(0, 1);

    }

    static void dfs(int depth, int start) {
        if (m == depth) {
            for(int i = 0; i < m; i++) {
                System.out.print(selected[i] + " ");
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
