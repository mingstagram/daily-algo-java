package No23_boj_7568;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[i][0] = x;
            arr[i][1] = y;
        }

        for(int i = 0; i < N; i++) {
            int score = 1;
            for(int j = 0; j < N; j++) {
                if(i != j) {
                    if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                        score++;
                    }
                }
            }
            sb.append(score).append(" ");
        }

        System.out.println(sb.toString());

    }
}
