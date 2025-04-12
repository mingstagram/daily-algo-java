package day27_2025_03_27;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            if (isGroupWord(word)) count++;
        }

        System.out.println(count);
    }

    private static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26];
        char prev = word.charAt(0);
        visited[prev - 'a'] = true;

        for (int i = 1; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (curr != prev) {
                if (visited[curr - 'a']) {
                    return false;
                }
                visited[curr - 'a'] = true;
                prev = curr;
            }
        }

        return true;
    }
}
