package No26_boj_1316;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            boolean[] visited = new boolean[26];
            boolean isChecked = true;

            for(int j = 0; j < word.length(); j++) {
                char current = word.charAt(j);
                if (j == 0) {
                    visited[current - 'a'] = true;
                    continue;
                }

                if (current != word.charAt(j - 1)) {
                    if (visited[current - 'a']) {
                        isChecked = false;
                        break;
                    }
                    visited[current - 'a'] = true;
                }
            }

            if(isChecked) count++;

        }

        System.out.println(count);


    }
}
