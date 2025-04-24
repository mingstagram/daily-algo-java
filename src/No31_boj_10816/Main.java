package No31_boj_10816;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            int card = sc.nextInt();
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int item = sc.nextInt();
            sb.append(map.getOrDefault(item, 0)).append(" ");
        }

        System.out.println(sb.toString());

    }
}
