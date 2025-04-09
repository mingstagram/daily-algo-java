package day02_2025_04_09;

import java.util.*;

public class Main {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            String command = sc.next();
            if(command.equals("push")) {
                int num = sc.nextInt();
                push(num);
            } else {
                switch (command) {
                    case "pop":
                        System.out.println(pop());
                        break;
                    case "size":
                        System.out.println(size());
                        break;
                    case "empty":
                        System.out.println(empty());
                        break;
                    case "top":
                        System.out.println(top());
                        break;
                }
            }
        }

    }

    static void push(int x) {
        stack.push(x);
    }

    static int pop() {
        if(stack.isEmpty()) return -1;
        else return stack.pop();
    }

    static int size() {
        return stack.size();
    }

    static int empty() {
        if(stack.isEmpty()) return 1;
        else return 0;
    }

    static int top() {
        if(stack.isEmpty()) return -1;
        else return stack.peek();
    }

}
