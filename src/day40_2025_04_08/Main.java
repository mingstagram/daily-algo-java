package day01_2025_04_08;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean valid = true;

            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) valid = false;
            System.out.println(valid ? "YES" : "NO");
        }
    }
}