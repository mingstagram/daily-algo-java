package No06_boj_1018;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        String[] board = new String[N];
        for (int i = 0; i < N; i++) board[i] = sc.next();

        int min = 64;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, repaint(board, i, j));
            }
        }
        System.out.println(min);
    }

    static int repaint(String[] board, int x, int y) {
        String[] pattern = {"WBWBWBWB", "BWBWBWBW"};
        int count1 = 0;
        for (int i = 0; i < 8; i++) {
            String expected = pattern[i % 2];
            for (int j = 0; j < 8; j++) {
                if (board[x + i].charAt(y + j) != expected.charAt(j)) count1++;
            }
        }
        return Math.min(count1, 64 - count1);
    }
}
