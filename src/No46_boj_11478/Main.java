package No46_boj_11478;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int length = S.length();
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= length; i++) {
            for(int j = 0; j < length + 1 - i; j++) {
                set.add(S.substring(j, j + i));
            }
        }
        System.out.println(set.size());
    }
}
