package No17_2_boj_1940;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int count = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int lt = 0;
        int rt = N - 1;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum == M) {
                count++;
                lt++;
                rt--;
            } else if (sum < M) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(count);

    }
}
