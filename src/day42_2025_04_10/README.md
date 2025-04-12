# 📅 2025-04-10 - 주유소 (백준 13305)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/13305](https://www.acmicpc.net/problem/13305)
- 난이도: 실버 3
- 알고리즘 분류: 그리디 알고리즘

---

## 📌 문제 요약

- N개의 도시가 일직선 상에 있고, 각 도시는 도로로 연결되어 있음
- 각 도시에는 주유소가 있으며, 기름 가격이 다름
- 1km당 1L의 기름을 사용하며, 도착지까지 가는 최소 비용을 계산해야 함

---

## 🔍 접근 방식

- 현재까지 가장 저렴한 주유소 가격을 기준으로 앞으로 갈 수 있는 거리만큼만 계산
- 매 도시마다 이전까지의 최소 가격을 유지하면서 현재 도시까지의 거리만큼 곱하여 비용 누적
- 그리디 알고리즘으로, **최소 가격을 계속 유지**하며 누적하는 방식

---

## 💡 배운 점 / 회고

- 단순히 최저 가격을 찾는 것이 아니라, **이동 경로상에서 가격 변화의 시점을 잘 추적**해야 함
- 이동 거리와 최소 가격을 동시에 고려하여 누적 계산하는 방식이 핵심
- 이 문제를 통해 그리디 알고리즘의 핵심 원리인 "앞으로의 최적 결정을 위한 현재 최선의 선택"을 체득할 수 있음

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] distance = new int[N - 1];
        int[] price = new int[N];

        for (int i = 0; i < N - 1; i++) {
            distance[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            price[i] = sc.nextInt();
        }

        long total = 0;
        int minPrice = price[0];

        for (int i = 0; i < N - 1; i++) {
            if (price[i] < minPrice) {
                minPrice = price[i];
            }
            total += (long) minPrice * distance[i];
        }

        System.out.println(total);
    }
}
