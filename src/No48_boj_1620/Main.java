package No48_boj_1620;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> numToName = new HashMap<>();
        Map<String, Integer> nameToNum = new HashMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            String name = sc.next();
            nameToNum.put(name, i);
            numToName.put(i, name);
        }

        for(int i = 0; i < m; i++) {
            String question = sc.next();
            if(isNumeric(question)) {
                // 정수형인경우
                int q = Integer.parseInt(question);
                System.out.println(numToName.get(q));
            } else {
                // 문자열인경우
                System.out.println(nameToNum.get(question));
            }
        }

    }

    static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
