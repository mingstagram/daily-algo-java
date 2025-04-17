package No18_boj_1181;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        List<String> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(String::length).thenComparing(s -> s));

        for (String s : list) {
            System.out.println(s);
        }

    }
}
