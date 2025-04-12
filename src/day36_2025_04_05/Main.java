package day36_2025_04_05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 제거

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            if (command.startsWith("push_front")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(x);
            } else if (command.startsWith("push_back")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                deque.addLast(x);
            } else if (command.equals("pop_front")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            } else if (command.equals("pop_back")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            } else if (command.equals("back")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }

        System.out.print(sb);
    }
}