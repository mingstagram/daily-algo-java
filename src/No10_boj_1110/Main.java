package No10_boj_1110;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < N; i++) {
            int cow = sc.nextInt();
            int location = sc.nextInt();
            if(map.containsKey(cow)) {
                if(map.get(cow) != location) {
                    count++;
                }
            }
            map.put(cow, location);
        }
        System.out.println(count);

    }
}
