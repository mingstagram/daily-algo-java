# 📅 2025-03-10 - 소가 길을 건너간 이유 (백준 14467)

- 문제 링크: [https://www.acmicpc.net/problem/14467](https://www.acmicpc.net/problem/14467)
- 난이도: 브론즈 1
- 알고리즘 분류: 구현

---

## 📌 문제 요약

- 소가 길을 건넌 기록이 주어짐
- 방향이 바뀐 횟수를 구하라

---

## 🔍 접근 방식

- 소 번호마다 마지막 방향을 기록
- 방향이 바뀌면 count 증가

---

## 💡 배운 점 / 회고

- 배열을 초기값 `-1`로 설정하여 상태를 관리
- 단순 조건 비교로 구현 가능

---

## 💻 코드

```java
package day10_2025_03_10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pos = new int[11];
        Arrays.fill(pos, -1);

        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int cow = sc.nextInt();
            int side = sc.nextInt();

            if (pos[cow] == -1) {
                pos[cow] = side;
            } else if (pos[cow] != side) {
                count++;
                pos[cow] = side;
            }
        }

        System.out.println(count);
    }
}

```
