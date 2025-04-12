package day30_2025_03_30;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] time = new int[N];

        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
        }

        Arrays.sort(time);

        int total = 0;
        int sum = 0;
        for (int t : time) {
            sum += t;
            total += sum;
        }

        System.out.println(total);
    }
}
