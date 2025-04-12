package day34_2025_04_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 제거

        int[] stack = new int[10000];
        int size = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            if (command.startsWith("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                stack[size++] = value;
            } else if (command.equals("pop")) {
                if (size == 0) sb.append(-1).append("\n");
                else sb.append(stack[--size]).append("\n");
            } else if (command.equals("size")) {
                sb.append(size).append("\n");
            } else if (command.equals("empty")) {
                sb.append(size == 0 ? 1 : 0).append("\n");
            } else if (command.equals("top")) {
                if (size == 0) sb.append(-1).append("\n");
                else sb.append(stack[size - 1]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
