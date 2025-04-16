package No02_boj_2675;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int R = sc.nextInt();
            String S = sc.next();
            StringBuilder sb = new StringBuilder();

            for (char c : S.toCharArray()) {
                sb.append(String.valueOf(c).repeat(R));
            }

            System.out.println(sb);
        }
    }
}