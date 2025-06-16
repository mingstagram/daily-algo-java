package No49_boj_10816;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int item = sc.nextInt();
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int item = sc.nextInt();
            sb.append(map.getOrDefault(item, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
