package day18_2025_03_18;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        int[] B = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (A[i] <= B[j]) {
                sb.append(A[i++]).append(" ");
            } else {
                sb.append(B[j++]).append(" ");
            }
        }

        while (i < n) sb.append(A[i++]).append(" ");
        while (j < m) sb.append(B[j++]).append(" ");

        System.out.println(sb);
    }
}
