package day05_2025_03_05;

import java.util.*;

public class Main {
    static List<Integer> triangle = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 45; i++) {
            triangle.add(i * (i + 1) / 2);
        }

        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();
            System.out.println(isEureka(K) ? 1 : 0);
        }
    }

    static boolean isEureka(int k) {
        for (int i : triangle)
            for (int j : triangle)
                for (int m : triangle)
                    if (i + j + m == k) return true;
        return false;
    }
}
