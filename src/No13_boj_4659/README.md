# 📅 2025-03-13 - 소인수분해 (백준 11653)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11653](https://www.acmicpc.net/problem/11653)
- 난이도: 브론즈 1
- 알고리즘 분류: 수학, 정수론, 소수 판정, 소인수분해

---

## 📌 문제 요약

- 정수 N이 주어졌을 때, N의 소인수를 오름차순으로 출력
- 하나의 소인수가 여러 번 나올 수 있음
- 더 이상 소인수가 없으면 종료

---

## 🔍 접근 방식

- 2부터 시작하여 N이 나누어질 수 있는 수인지 확인하고, 나눌 수 있는 동안 계속 나눔
- 나누어지지 않을 경우 다음 수로 증가
- N이 1이 될 때까지 반복
- 반복이 끝난 후 N이 1보다 크면 그 수 역시 소인수이므로 출력

---

## 💡 배운 점 / 회고

- 소인수분해는 특정 수로 나누어 떨어질 때까지 나누는 방식으로 간단히 구현 가능
- 소수를 구하는 문제와 달리, 소인수만 출력하면 되므로 소수 판별 과정 없이 효율적으로 풀이 가능
- 시간 복잡도는 약 O(√N)으로 충분히 빠르게 처리 가능

---

## 💻 코드

```java 
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
