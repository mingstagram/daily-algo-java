package No16_boj_11659;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] s = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            s[i] = s[i - 1] + sc.nextInt(); // 누적합 계산
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(s[end] - s[start - 1]); // 구간합 출력
        }
    }
}
