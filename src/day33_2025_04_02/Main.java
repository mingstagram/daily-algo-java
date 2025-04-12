package day33_2025_04_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 개행 제거

        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            if (isVPS(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isVPS(String str) {
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
                if (count < 0) return false;
            }
        }

        return count == 0;
    }
}
