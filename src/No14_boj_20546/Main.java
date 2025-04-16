package No14_boj_20546;

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

//        System.out.println("junhyun -----> " + junhyun);
//        System.out.println("sungmin -----> " + sungmin);

        if(junhyun > sungmin) {
            System.out.println("BNP");
        } else if(junhyun < sungmin) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }

    }

    static int junhyun_skill(int money) {
        // 준현이는 한번 주실을 살 수 있다면 무조건 최대한 많이 산다.
        // 따로 매도는 하지않는다.
        int stock_status = 0;
        int holding_money = 0;
        for(int i = 0; i < 14; i++) {

            if(money >= stocks[i]) {
                stock_status += money / stocks[i];
                money = money % stocks[i];
            }

            if(i == 13) {
                holding_money = money + (stock_status * stocks[i]);
            }

        }

        return holding_money;
    }

    static int sungmin_skill(int money) {
        // 성민이는 3일 연속 가격이 전일 대비 상스하는 주식은 다음날 무조건 전량 매도함.
        // 3일 연속 가격이 전일 대비 하락하는 주식은 다음날 무조건 전량 매수함.
        int stock_status = 0; // 보유한 주식 수
        int holding_money = 0; // 보유 자산
        int up_day_count = 0; // 상승 연속 일수 카운트
        int down_day_count = 0; // 하락 연속 일수 카운트

        // 100
        // 10 20 23 34 55 30 22 19 12 45 23 44 34 38
        for(int i = 0; i < 13; i++) {
            if(stocks[i] > stocks[i+1]) {
                down_day_count++;
                up_day_count = 0;
            } else if(stocks[i] < stocks[i+1]) {
                up_day_count++;
                down_day_count = 0;
            } else {
                up_day_count = 0;
                down_day_count = 0;
            }

            if(up_day_count >= 3) {
                // 전량 매도
                money += stocks[i + 1] * stock_status;
                stock_status = 0;
            } else if(down_day_count >= 3) {
                // 전량 매수
                stock_status += money / stocks[i + 1];
                money -= (money / stocks[i + 1] * stocks[i+1]);
            }

            if(i == 12 && stock_status > 0) {
                money += stocks[i+1] * stock_status;
                stock_status = 0;
            }

        }

        return money;
    }


}
