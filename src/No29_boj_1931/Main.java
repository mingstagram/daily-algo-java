package No29_boj_1931;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] times = new int[N][2];
        for(int i = 0 ; i < N; i++) {
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
        }

        Arrays.sort(times, (e1, e2) -> {
            if (e1[1] == e2[1]) {
                return e1[0] - e2[0];
            }
            return e1[1] - e2[1];
        });

        int count = 1;
        int end = times[0][1];

        for(int j  = 1; j < N; j++) {
            if(end <= times[j][0]) {
                end = times[j][1];
                count++;
            }
        }

        System.out.println(count);

    }
}
