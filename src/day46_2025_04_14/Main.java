package day46_2025_04_14;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        int[][] dp = new int[41][2]; // 0 <= n <= 40
        dp[0][0] = 1; dp[0][1] = 0; // f(0) 호출 시
        dp[1][0] = 0; dp[1][1] = 1; // f(1) 호출 시

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
