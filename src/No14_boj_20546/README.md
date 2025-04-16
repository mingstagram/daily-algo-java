# 📅 2025-03-15 - 기적의 매매법 (백준 20546)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/20546](https://www.acmicpc.net/problem/20546)
- 난이도: 실버 3
- 알고리즘 분류: 구현, 시뮬레이션

---

## 📌 문제 요약

- 두 명의 투자자 **준현**과 **성민**이 각자 다른 전략으로 주식 거래를 진행한다.
- 초기 자금으로 14일간 주식 매매를 시뮬레이션하여, 마지막 날 보유 자산이 더 많은 사람을 판별해야 한다.

### ✅ 투자 전략

#### 📈 BNP (준현)
- Buy and Pray 전략.
- 살 수 있으면 가능한 한 최대한 많이 매수.
- 매도는 하지 않음.

#### 📊 TIMING (성민)
- 3일 연속 상승: 다음 날 하락을 예측하고 전량 매도.
- 3일 연속 하락: 다음 날 상승을 예측하고 전량 매수.
- 가격이 동일한 날은 상승/하락으로 간주하지 않음.

---

## 🔍 접근 방식

- 준현은 단순 매수 전략이라 매수 조건만 확인하면 됨.
- 성민은 상태 추적(연속 상승/하락 일수)을 통해 조건 충족 시 매수/매도를 수행해야 함.
- 마지막 날 보유 주식의 시세로 환산한 자산까지 합산.

---

## 💡 배운 점 / 회고

- 주가 시뮬레이션 문제는 상태 추적과 조건 분기가 핵심.
- 날짜 인덱스와 조건 충족 시점(다음 날 거래)에 대한 로직이 헷갈릴 수 있으므로 주의 필요.
- 마지막 날 보유 주식에 대한 정산도 반드시 포함해야 함.
- 조건이 복잡할수록 **단계별 print 디버깅이 큰 도움이 됨**.

---

## 💻 코드

```java
import java.util.*;

public class Main {

    static int[] stocks = new int[14];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();

        for (int i = 0; i < 14; i++) {
            stocks[i] = sc.nextInt();
        }

        int junhyun = junhyun_skill(money);
        int sungmin = sungmin_skill(money);

        if (junhyun > sungmin) {
            System.out.println("BNP");
        } else if (junhyun < sungmin) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    static int junhyun_skill(int money) {
        int stock = 0;
        for (int i = 0; i < 14; i++) {
            if (money >= stocks[i]) {
                stock += money / stocks[i];
                money = money % stocks[i];
            }
        }
        return money + stock * stocks[13];
    }

    static int sungmin_skill(int money) {
        int stock = 0;
        int up = 0, down = 0;

        for (int i = 0; i < 13; i++) {
            if (stocks[i] < stocks[i + 1]) {
                up++;
                down = 0;
            } else if (stocks[i] > stocks[i + 1]) {
                down++;
                up = 0;
            } else {
                up = 0;
                down = 0;
            }

            if (up >= 3) {
                money += stock * stocks[i + 1];
                stock = 0;
            } else if (down >= 3) {
                int canBuy = money / stocks[i + 1];
                stock += canBuy;
                money -= canBuy * stocks[i + 1];
            }
        }

        return money + stock * stocks[13];
    }
}
