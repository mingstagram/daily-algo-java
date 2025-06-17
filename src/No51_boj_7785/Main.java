package No51_boj_7785;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            String name = sc.next();
            String action = sc.next();
            if(action.equals("enter")) {
                set.add(name);
            } else if(action.equals("leave")) {
                set.remove(name);
            }
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        for(String name : list) {
            System.out.println(name);
        }

    }
}
