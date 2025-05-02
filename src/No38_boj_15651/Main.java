package No38_boj_15651;

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
        dfs(0);
        System.out.println(sb.toString());
    }

    static void dfs(int depth) {
        if(m == depth) {
            for(int i = 0 ; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            selected[depth] = i;
            dfs(depth + 1);
        }
    }
}
