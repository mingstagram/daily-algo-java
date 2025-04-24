package No30_boj_18870;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] origin = new int[N];
        int[] sorted = new int[N];

        for(int i = 0; i < N; i++) {
            origin[i] = sc.nextInt();
            sorted[i] = origin[i];
        }

        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for(int i = 0; i < N; i++){
            if(!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            sb.append(map.get(origin[i])).append(" ");
        }

        System.out.println(sb.toString());

    }
}
