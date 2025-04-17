package No17_0_boj_11728;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] arrays_A = new long[N];
        long[] arrays_B = new long[M];
        for(int i = 0; i < N; i++ ) {
            arrays_A[i] = sc.nextLong();
        }
        for(int i = 0; i < M; i++ ) {
            arrays_B[i] = sc.nextLong();
        }
        int i = 0;
        int j = 0;

        while(i < arrays_A.length && j < arrays_B.length) {
            if(arrays_A[i] <= arrays_B[j]) {
                sb.append(arrays_A[i]).append(" ");
                i++;
            } else {
                sb.append(arrays_B[j]).append(" ");
                j++;
            }
        }

        while (i < arrays_A.length) {
            sb.append(arrays_A[i]).append(" ");
            i++;
        }

        while (j < arrays_B.length) {
            sb.append(arrays_B[j]).append(" ");
            j++;
        }

        System.out.println(sb.toString());

    }
}
