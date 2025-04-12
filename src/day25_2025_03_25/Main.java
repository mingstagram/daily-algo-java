package day25_2025_03_25;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (isHansu(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isHansu(int num) {
        if (num < 100) return true;

        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num % 10;

        return (a - b) == (b - c);
    }
}
