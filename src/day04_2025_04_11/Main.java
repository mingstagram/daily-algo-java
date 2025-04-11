package day04_2025_04_11;

import java.util.*;

public class Main {

    static Deque<Integer> deque = new LinkedList<>();
    static ArrayDeque<Integer> array_deque = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            switch (command) {
                case "push_front" :
                    push_front(sc.nextInt());
                    break;
                case "push_back" :
                    push_back(sc.nextInt());
                    break;
                case "pop_front" :
                    sb.append(pop_front()).append("\n");
                    break;
                case "pop_back" :
                    sb.append(pop_back()).append("\n");
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

    static void push_front(int x) {
        deque.offerFirst(x);
    }

    static void push_back(int x) {
        deque.offerLast(x);
    }

    static int pop_front() {
        if(deque.isEmpty()) return -1;
        else return deque.pollFirst();
    }

    static int pop_back() {
        if(deque.isEmpty()) return -1;
        else return deque.pollLast();
    }

    static int size() {
        return deque.size();
    }

    static int empty() {
        if(deque.isEmpty()) return 1;
        else return 0;
    }

    static int front() {
        if(deque.isEmpty()) return -1;
        else return deque.peekFirst();
    }

    static int back() {
        if(deque.isEmpty()) return -1;
        else return deque.peekLast();
    }

}
