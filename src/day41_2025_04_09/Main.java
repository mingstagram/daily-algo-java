package day41_2025_04_09;

import java.util.*;

public class Main {
    static int N, M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];

        dfs(0, 1);
        System.out.print(sb);
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            result[depth] = i;
            dfs(depth + 1, i); // 중복 허용 → i부터 다시 시작
        }
    }
}
