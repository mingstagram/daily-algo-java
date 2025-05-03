package No39_boj_15652;

import java.util.*;

public class Main {

    static int n, m;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        selected = new int[m];
        dfs(0, 1);
        System.out.println(sb.toString());
    }

    static void dfs(int depth, int start) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= n; i++) {
            selected[depth] = i;
            dfs(depth + 1, i);
        }

    }

}
