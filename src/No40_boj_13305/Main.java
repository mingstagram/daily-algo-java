package No40_boj_13305;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min_price = Integer.MAX_VALUE;
        long total = 0;
        int n = sc.nextInt();
        long[] distance = new long[n - 1];
        long[] price = new long[n];
        for(int i = 0; i < n - 1; i++) {
            distance[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            price[i] = sc.nextLong();
        }

        for(int i = 0; i < n - 1; i++) {
            min_price = Math.min(min_price, price[i]);
            total += min_price * distance[i];
        }

        System.out.println(total);

    }
}
