package day15_2025_03_15;

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