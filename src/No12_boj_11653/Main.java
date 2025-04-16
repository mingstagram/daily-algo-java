package No12_boj_11653;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }

    // 최대공약수
    static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    // 최소공배수
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}