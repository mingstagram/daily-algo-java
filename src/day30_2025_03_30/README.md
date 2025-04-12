# 📅 2025-03-30 - ATM (백준 11399)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11399](https://www.acmicpc.net/problem/11399)
- 난이도: 실버 4
- 알고리즘 분류: 그리디 알고리즘, 정렬

---

## 📌 문제 요약

- 각 사람이 돈을 인출하는 데 걸리는 시간이 주어질 때, **각 사람이 기다리는 시간의 총합**이 최소가 되도록 줄을 세워야 함
- 총합이 최소가 되는 경우의 시간을 구해야 함

---

## 🔍 접근 방식

- 각 사람이 기다리는 시간은 이전 사람들의 대기 시간의 누적합으로 계산됨
- **작은 시간부터 먼저 배치**하면 전체 합이 최소가 됨 → 오름차순 정렬이 핵심
- 누적합을 통해 각 사람이 걸리는 시간의 총합을 구함

---

## 💡 배운 점 / 회고

- 최소 대기 시간 문제는 대부분 **정렬 + 누적합** 패턴으로 해결 가능
- 앞사람의 시간이 반복적으로 뒤 사람에게 영향을 준다는 구조를 이해해야 함
- 단순한 정렬 문제지만, 그리디 알고리즘의 직관을 잘 익힐 수 있음

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] time = new int[N];

        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
        }

        Arrays.sort(time);

        int total = 0;
        int sum = 0;
        for (int t : time) {
            sum += t;
            total += sum;
        }

        System.out.println(total);
    }
}
