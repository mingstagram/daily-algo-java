package day16_2025_03_16;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        long sum = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            sum += A[i];
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            sum -= A[i];
            result += (long) A[i] * sum;
        }

        System.out.println(result);
    }
}
