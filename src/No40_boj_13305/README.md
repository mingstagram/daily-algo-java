# 📅 주유소 (백준 13305)

- 문제 링크: [https://www.acmicpc.net/problem/13305](https://www.acmicpc.net/problem/13305)
- 난이도: 실버 3
- 알고리즘 분류: 그리디 알고리즘

---

## 📌 문제 요약

- N개의 도시가 일직선으로 존재하며, 도시 사이의 도로마다 길이가 다르다.
- 각 도시에 하나의 주유소가 있고, 리터당 기름 가격이 다르다.
- 출발 도시부터 도착 도시까지의 이동에 필요한 최소 비용을 계산하라.
- **도로 이동 시 1km당 1L의 기름이 소모되며**, 기름은 **도시마다 원하는 만큼 넣을 수 있다.**

---

## 🔍 접근 방식

- 핵심 아이디어는 **가장 싼 기름값을 유지하며 이동하는 것**이다.
- **그리디 알고리즘**을 적용하여, 현재까지의 최소 기름값을 저장하면서 이동 구간마다 비용을 누적
- `Math.min()`을 사용해 **현재까지의 최소 리터당 가격을 갱신**
- 거리와 가격을 따로 배열로 저장하고, 거리만큼 반복하며 최소 비용 계산

---

## 💡 배운 점 / 회고

- 이 문제는 단순히 계산 문제가 아니라 **탐욕적으로 누적 비용을 최소화하는 전략이 필요한 문제**였다.
- 백트래킹, DP 등을 고민할 수 있지만, "항상 최소 단가로 최대한 주유"하는 전략으로 풀 수 있는 그리디 문제였다.
- **자료형을 int가 아닌 long으로 설정**하지 않으면 거리나 가격 곱셈에서 오버플로우가 발생할 수 있다는 점도 기억해야 한다.
- 조건을 잘 해석하고 **"무한 주유 가능"이라는 점을 눈치채는 게 핵심 포인트**였다.

---

## 💻 코드

```java 
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long min_price = Integer.MAX_VALUE;
        long total = 0;
        int n = sc.nextInt();

        long[] distance = new long[n - 1];
        long[] price = new long[n];

        for (int i = 0; i < n - 1; i++) {
            distance[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) {
            price[i] = sc.nextLong();
        }

        for (int i = 0; i < n - 1; i++) {
            min_price = Math.min(min_price, price[i]);
            total += min_price * distance[i];
        }

        System.out.println(total);
    }
}
