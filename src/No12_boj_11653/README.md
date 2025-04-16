# 📅 2025-03-12 - 최대공약수와 최소공배수

- 관련 문제 링크 (예시): [https://www.acmicpc.net/problem/2609](https://www.acmicpc.net/problem/2609)
- 난이도: 브론즈 1
- 알고리즘 분류: 수학, 유클리드 호제법

---

## 📌 문제 요약

- 두 개의 자연수 `a`, `b`가 주어졌을 때,
    - **최대공약수(GCD)**: 두 수가 공통으로 나눌 수 있는 가장 큰 수
    - **최소공배수(LCM)**: 두 수의 공통 배수 중 가장 작은 수
- 두 값을 각각 구해 출력하는 문제

---

## 🔍 접근 방식

- 최대공약수는 **유클리드 호제법**을 이용하여 재귀적으로 계산
- 최소공배수는 `a * b / GCD(a, b)` 공식을 활용해 계산
- 입력은 두 수 `a`, `b`, 출력은 각각의 결과

---

## 💡 배운 점 / 회고

- 유클리드 호제법은 최대공약수를 구할 때 가장 빠르고 효율적인 방법
- 최소공배수는 최대공약수를 기반으로 쉽게 구할 수 있음
- 실전에서는 **오버플로우**를 방지하기 위해 long형이나 BigInteger도 고려할 수 있음

---

## 💻 코드

```java 
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

    // 최대공약수
    static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    // 최소공배수
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
