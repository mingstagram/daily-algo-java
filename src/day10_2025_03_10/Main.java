package day10_2025_03_10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pos = new int[11];
        Arrays.fill(pos, -1);

        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int cow = sc.nextInt();
            int side = sc.nextInt();

            if (pos[cow] == -1) {
                pos[cow] = side;
            } else if (pos[cow] != side) {
                count++;
                pos[cow] = side;
            }
        }

        System.out.println(count);
    }
}
