package day11_2025_03_11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int original = N;
        int count = 0;

        do {
            int tens = N / 10;
            int ones = N % 10;
            int sum = tens + ones;
            N = (ones * 10) + (sum % 10);
            count++;
        } while (N != original);

        System.out.println(count);
    }
}