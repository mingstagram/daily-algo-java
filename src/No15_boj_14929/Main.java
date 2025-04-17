package No15_boj_14929;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        long total = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        long result = 0;
        for(int i = 0; i < N; i++) {
            total -= arr[i];
            result += total * arr[i];
        }

        System.out.println(result);
    }
}
