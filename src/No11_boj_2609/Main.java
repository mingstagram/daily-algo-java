package No11_boj_2609;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int current = N;
        int count = 0;

        do{
            int a = current / 10; // 십의 자리
            int b = current % 10; // 일의 자리
            int sum = a + b;
            current = (b * 10) + (sum % 10);
            count++;
        } while (current != N);

        System.out.println(count);

    }
}