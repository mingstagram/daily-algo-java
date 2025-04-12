package day03_2025_03_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        long count = Arrays.stream(S.trim().split(" "))
                .filter(s -> !s.isEmpty())
                .count();
        System.out.println(count);
    }
}
