# 📅 2025-03-18 - 배열 합치기 (백준 11728)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11728](https://www.acmicpc.net/problem/11728)
- 난이도: 실버 5
- 알고리즘 분류: 정렬, 투 포인터

---

## 📌 문제 요약

- 오름차순으로 정렬된 두 배열 A, B가 주어졌을 때, 두 배열을 하나로 합쳐 다시 오름차순으로 출력해야 함

---

## 🔍 접근 방식

- 두 배열이 이미 정렬되어 있으므로 **투 포인터** 기법을 활용하여 병합 정렬 방식으로 하나의 배열로 합침
- 포인터를 각각 배열 A와 B에 두고, 작은 값을 결과 리스트에 먼저 추가
- 어느 한 배열을 모두 순회한 후 남은 배열의 나머지를 결과에 이어 붙임

---

## 💡 배운 점 / 회고

- 정렬된 배열 두 개를 병합할 때는 정렬 알고리즘 없이도 투 포인터만으로 O(N+M) 시간에 해결 가능
- Java에서 `BufferedReader`와 `StringBuilder`를 사용하면 대용량 입력/출력에서도 성능을 보장할 수 있음
- 기본적인 정렬 문제와 달리 입력 조건(정렬됨)을 적극 활용하면 더 빠른 코드 구현이 가능함

---

## 💻 코드

```java
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
