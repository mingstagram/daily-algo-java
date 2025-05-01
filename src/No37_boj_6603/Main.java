package No37_boj_6603;

import java.util.*;

public class Main {

    static int k;
    final static int m = 6; // 로또 추첨 6개 고정
    static int[] selected;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            k = sc.nextInt();
            if(k == 0) break;
            arr = new int[k];
            selected = new int[m];
            for(int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            dfs(0, 0);
            System.out.println();
        }
    }

    static void dfs(int depth, int start) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < k; i++) {
            selected[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }

    }

}
