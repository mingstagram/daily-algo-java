package No28_boj_11047;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        Integer[] coins = new Integer[N];
        int count = 0;

        for(int i = 0 ; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins, Collections.reverseOrder());
        int i = 0;
        while(K > 0) {
            if(K >= coins[i]) {
               count += K / coins[i];
               K %= coins[i];
            }
            i++;
        }

        System.out.println(count);

    }
}
