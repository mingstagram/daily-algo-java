package No34_boj_10845;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push")) {
                queue.add(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
            } else if (command.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : ((LinkedList<Integer>) queue).peekLast()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}