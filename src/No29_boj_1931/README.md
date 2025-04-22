# 📅 회의실 배정 (백준 1931)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1931](https://www.acmicpc.net/problem/1931)
- 난이도: 골드 5
- 알고리즘 분류: 그리디, 정렬

---

## 📌 문제 요약

- N개의 회의에 대해 각 회의의 시작 시간과 끝나는 시간이 주어진다.
- 한 개의 회의실에서 한 번에 하나의 회의만 할 수 있을 때,
- 회의가 겹치지 않도록 하면서 회의를 최대한 많이 배정하려고 한다.
- 회의의 시작 시간과 끝나는 시간이 같을 수도 있다.
- 회의를 최대 몇 개까지 배정할 수 있는지 구하라.

---

## 🔍 접근 방식

- **끝나는 시간을 기준으로 오름차순 정렬**한다.
- 가장 빨리 끝나는 회의를 우선 선택하고, 그 이후에는 현재 회의의 끝나는 시간보다 **같거나 늦게 시작하는 회의**만 선택한다.
- 즉, `end <= 다음 회의 시작시간`일 때만 회의 개수를 증가시키고, end를 갱신하는 방식으로 진행한다.
- 이 방법으로 전체 회의 중 **겹치지 않고 최대한 많이 고를 수 있다.**

---

## 💡 배운 점 / 회고

- 시작 시간 기준으로 정렬하면 틀릴 수 있음 → **종료 시간 기준 정렬이 핵심**
- 그리디 문제는 정렬 기준을 잘 설정하면 생각보다 훨씬 간단하게 풀린다.
- 처음엔 브루트포스로 모든 경우 탐색하고 싶어졌지만, 문제의 핵심 조건에 집중했더니 훨씬 효율적인 방법이 보였다.
- **단순한 조건 하나가 효율적인 알고리즘의 기준이 될 수 있다**는 걸 다시 느낌.

---

## 💻 코드

```java
package No29_boj_1931;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] times = new int[N][2];

        for (int i = 0; i < N; i++) {
            times[i][0] = sc.nextInt(); // 시작 시간
            times[i][1] = sc.nextInt(); // 종료 시간
        }

        // 종료 시간 기준 정렬 (같으면 시작 시간 오름차순)
        Arrays.sort(times, (e1, e2) -> {
            if (e1[1] == e2[1]) return e1[0] - e2[0];
            return e1[1] - e2[1];
        });

        int count = 1;
        int end = times[0][1];

        for (int j = 1; j < N; j++) {
            if (end <= times[j][0]) {
                end = times[j][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
