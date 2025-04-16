package No01_boj_8958;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 개행 처리

        for (int i = 0; i < T; i++) {
            String line = sc.nextLine();
            int score = 0;
            int current = 0;

            for (char ch : line.toCharArray()) {
                if (ch == 'O') {
                    current++;
                    score += current;
                } else {
                    current = 0;
                }
            }

            System.out.println(score);
        }
    }
}