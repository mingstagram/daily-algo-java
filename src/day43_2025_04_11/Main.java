package day43_2025_04_11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // 개행 제거

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String query = sc.nextLine();
            if (set.contains(query)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
