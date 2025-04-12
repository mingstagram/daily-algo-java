package day42_2025_04_10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] distance = new int[N - 1];
        int[] price = new int[N];

        for (int i = 0; i < N - 1; i++) {
            distance[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            price[i] = sc.nextInt();
        }

        long total = 0;
        int minPrice = price[0];

        for (int i = 0; i < N - 1; i++) {
            if (price[i] < minPrice) {
                minPrice = price[i];
            }
            total += (long) minPrice * distance[i];
        }

        System.out.println(total);
    }
}
