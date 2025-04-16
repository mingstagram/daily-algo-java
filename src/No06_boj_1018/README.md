# 📅 2025-03-06 - 체스판 다시 칠하기 (백준 1018)

- 문제 링크: [https://www.acmicpc.net/problem/1018](https://www.acmicpc.net/problem/1018)
- 난이도: 브론즈 1
- 알고리즘 분류: 브루트포스

---

## 📌 문제 요약

- `NxM` 크기의 체스판에서 8x8 부분을 골라서 흑백 칠을 다시 할 때 최소 변경 횟수 구하기

---

## 🔍 접근 방식

- 모든 8x8 부분 체스판에 대해 검사
- 시작이 'W' 혹은 'B'일 때의 차이를 모두 확인
- 64칸 중에서 `count`와 `64 - count` 중 작은 값이 최소 변경 수

---

## 💡 배운 점 / 회고

- 체계적인 브루트포스 로직 연습
- 작은 체스판의 패턴을 기준으로 비교하는 방식이 깔끔했음

---

## 💻 코드

```java
package day06_2025_03_06;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        String[] board = new String[N];
        for (int i = 0; i < N; i++) board[i] = sc.next();

        int min = 64;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, repaint(board, i, j));
            }
        }
        System.out.println(min);
    }

    static int repaint(String[] board, int x, int y) {
        String[] pattern = {"WBWBWBWB", "BWBWBWBW"};
        int count1 = 0;
        for (int i = 0; i < 8; i++) {
            String expected = pattern[i % 2];
            for (int j = 0; j < 8; j++) {
                if (board[x + i].charAt(y + j) != expected.charAt(j)) count1++;
            }
        }
        return Math.min(count1, 64 - count1);
    }
}

```
