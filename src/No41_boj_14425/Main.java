package No41_boj_14425;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int total = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(sc.next());
        }

        for(int i = 0; i < m; i++) {
            String result = sc.next();
            if(set.contains(result)) total++;
        }

        System.out.println(total);

    }
}
