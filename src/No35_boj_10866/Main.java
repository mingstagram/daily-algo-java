package No35_boj_10866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push_front")) {
                deque.addFirst(Integer.parseInt(command.split(" ")[1]));
            } else if (command.startsWith("push_back")) {
                deque.addLast(Integer.parseInt(command.split(" ")[1]));
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

        System.out.println(sb.toString());
    }
}