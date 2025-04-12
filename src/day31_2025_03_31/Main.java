package day31_2025_03_31;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            if (Arrays.binarySearch(A, target) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
