package No19_boj_11650;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });

        for(int[] items : arr) {
            sb.append(items[0]).append(" ").append(items[1]).append("\n");
        }

        System.out.println(sb.toString());

    }
}
