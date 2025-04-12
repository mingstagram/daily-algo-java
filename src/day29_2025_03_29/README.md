# 📅 2025-03-29 - 동전 0 (백준 11047)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11047](https://www.acmicpc.net/problem/11047)
- 난이도: 실버 4
- 알고리즘 분류: 그리디 알고리즘

---

## 📌 문제 요약

- N개의 동전 단위가 주어지고, 이를 사용해 금액 K를 만들 때 필요한 **동전의 최소 개수**를 구하는 문제
- 각 동전은 **무한히 존재**함
- 동전 단위는 오름차순으로 주어짐

---

## 🔍 접근 방식

- 가장 큰 단위부터 사용해서 K를 최대한 나누는 방식의 **그리디 알고리즘** 적용
- K가 0이 될 때까지 반복하면서 나눌 수 있는 최대 개수만큼 차감하고 카운트 증가
- 동전은 항상 배수 단위이므로 그리디 방식으로 최적 해 보장됨

---

## 💡 배운 점 / 회고

- 문제 조건(동전 단위가 배수 관계)을 잘 이해하면 그리디가 성립함을 쉽게 파악 가능
- 내림차순 순회 및 나눗셈 활용이 간단하고 빠르게 해결되는 패턴
- 현실적인 문제(거스름돈, 자판기 등)와 연결해 사고할 수 있는 실전 문제 유형

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= K) {
                count += K / coins[i];
                K %= coins[i];
            }
        }

        System.out.println(count);
    }
}
