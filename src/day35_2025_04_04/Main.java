package day35_2025_04_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 제거

        int[] queue = new int[10000];
        int front = 0;
        int rear = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            if (command.startsWith("push")) {
                int val = Integer.parseInt(command.split(" ")[1]);
                queue[rear++] = val;
            } else if (command.equals("pop")) {
                if (front == rear) sb.append(-1).append("\n");
                else sb.append(queue[front++]).append("\n");
            } else if (command.equals("size")) {
                sb.append(rear - front).append("\n");
            } else if (command.equals("empty")) {
                sb.append(front == rear ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                if (front == rear) sb.append(-1).append("\n");
                else sb.append(queue[front]).append("\n");
            } else if (command.equals("back")) {
                if (front == rear) sb.append(-1).append("\n");
                else sb.append(queue[rear - 1]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
