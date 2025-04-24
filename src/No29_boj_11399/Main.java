package No29_boj_11399;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int total = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
            total += sum;
        }

        System.out.println(total);

    }
}
