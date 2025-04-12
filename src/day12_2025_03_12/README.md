# 📅 2025-03-12 - 소인수분해 (백준 11653)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11653](https://www.acmicpc.net/problem/11653)
- 난이도: 브론즈 1
- 알고리즘 분류: 수학, 정수론, 소수 판정, 소인수분해

---

## 📌 문제 요약

- 정수 N이 주어졌을 때, N의 **소인수**를 오름차순으로 출력
- 한 줄에 하나씩 출력하며, 더 이상 소인수가 없으면 종료 

---

## 🔍 접근 방식

- 2부터 시작하여 N이 해당 수로 나눠질 수 있는 동안 계속 나눔
- 나눌 수 없다면 다음 수로 증가
- N이 1이 될 때까지 반복

💡 시간복잡도는 약 `O(√N)`으로 충분히 빠름  
※ 에라토스테네스의 체 없이도 소인수만 구하는 문제에서는 이 방식으로 충분

---

## 💡 배운 점 / 회고

- 소인수분해 문제는 **"나눌 수 있을 때까지 나눈다"**는 단순한 논리로 해결 가능
- **반복문 안에서 내부적으로 N이 변하는 방식**에 익숙해지기 좋음
- 소수를 찾는 문제와는 다르며, 굳이 소수 판별까지 갈 필요는 없음

---

## 💻 코드

```java
package day04_2025_03_12;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                System.out.println(i);
                N /= i;
            }
        }

        if (N > 1) {
            System.out.println(N);
        }
    }
}