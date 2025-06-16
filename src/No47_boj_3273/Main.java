package No47_boj_3273;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        int result = 0;
        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        while(start < end) {
            int current = arr[start] + arr[end];
            if(current == sum) {
                result++;
                start++;
                end--;
            } else if(current < sum) {
                start++; // 합이 작으면 start 오른쪽으로
            } else {
                end--;   // 합이 크면 end 왼쪽으로
            }
        }

        System.out.println(result);

    }
}
