package No30_boj_1920;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);  // 이분탐색 전 정렬 필수
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int num = sc.nextInt();
            sb.append(binarySearch(arr, num)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) return 1;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return 0;
    }

}
