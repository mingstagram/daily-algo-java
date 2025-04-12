# 📅 2025-03-15 - 기적의 매매법 (백준 20546)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/20546](https://www.acmicpc.net/problem/20546)
- 난이도: 실버 5
- 알고리즘 분류: 구현, 시뮬레이션

---

## 📌 문제 요약

- BNP와 TIMING이라는 두 가지 매매 전략 중 어떤 전략이 더 수익이 높은지를 비교
- 입력으로 초기 자금과 14일 간의 주가 정보가 주어짐
- 각 전략의 방식대로 주식을 사고팔아 마지막 날 기준 자산 총액을 계산한 후, 더 높은 전략을 출력

---

## 🔍 접근 방식

- BNP 방식은 주가가 낮을 때 최대한 주식을 매수하고 이후 보유만 함
- TIMING 방식은 3일 연속 상승 시 매도, 3일 연속 하락 시 매수
- 각 전략별로 자산 계산 후 비교하여 결과 출력

---

## 💡 배운 점 / 회고

- 간단한 조건 기반 시뮬레이션 문제로, 전략에 따라 상태를 잘 추적하고 처리하면 됨
- 전략 조건(3일 연속 상승/하락)에 대한 슬라이딩 윈도우 방식의 로직 구현이 핵심
- 실제 금융 로직을 코드로 옮기는 연습에 적합한 문제

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cash = sc.nextInt();
        int[] prices = new int[14];
        for (int i = 0; i < 14; i++) {
            prices[i] = sc.nextInt();
        }

        // BNP 전략
        int bnpCash = cash;
        int bnpStock = 0;
        for (int price : prices) {
            int buyCount = bnpCash / price;
            bnpStock += buyCount;
            bnpCash -= buyCount * price;
        }
        int bnpTotal = bnpCash + bnpStock * prices[13];

        // TIMING 전략
        int timingCash = cash;
        int timingStock = 0;
        for (int i = 3; i < 14; i++) {
            if (prices[i - 3] < prices[i - 2] &&
                prices[i - 2] < prices[i - 1]) {
                // 3일 연속 상승 → 전량 매도
                timingCash += timingStock * prices[i];
                timingStock = 0;
            } else if (prices[i - 3] > prices[i - 2] &&
                       prices[i - 2] > prices[i - 1]) {
                // 3일 연속 하락 → 전액 매수
                int buyCount = timingCash / prices[i];
                timingStock += buyCount;
                timingCash -= buyCount * prices[i];
            }
        }
        int timingTotal = timingCash + timingStock * prices[13];

        // 결과 비교
        if (bnpTotal > timingTotal) {
            System.out.println("BNP");
        } else if (bnpTotal < timingTotal) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
