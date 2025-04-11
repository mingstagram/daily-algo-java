package day03_2025_04_10;

import java.util.*;

public class Main {

    static Queue<Integer> queue = new LinkedList<>();
    static int last = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            switch (command) {
                case "push" :
                    int x = sc.nextInt();
                    push(x);
                    break;
                case "pop" :
                    sb.append(pop()).append("\n");
                    break;
                case "size" :
                    sb.append(size()).append("\n");
                    break;
                case "empty" :
                    sb.append(empty()).append("\n");
                    break;
                case "front" :
                    sb.append(front()).append("\n");
                    break;
                case "back" :
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    static void push(int x) {
        queue.offer(x);
        last = x;
    }

    static int pop() {
        if (queue.isEmpty()) return -1;
        else return queue.poll();
    }

    static int size() {
        return queue.size();
    }

    static int empty() {
        if (queue.isEmpty()) return 1;
        else return 0;
    }

    static int front() {
        if (queue.isEmpty()) return -1;
        else return queue.peek();
    }

    static int back() {
        if (queue.isEmpty()) return -1;
        return last;
    }
}
