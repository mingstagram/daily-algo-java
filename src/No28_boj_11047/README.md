# 📘 백준 11047번 - 동전 0

- 🔗 문제 링크: [https://www.acmicpc.net/problem/11047](https://www.acmicpc.net/problem/11047)
- 🏷️ 분류: 그리디 알고리즘
- 🟢 난이도: 실버 4

---

## 📌 문제 요약

- N종류의 동전이 있다. 각 동전은 가치가 다르고 무한히 사용할 수 있다.
- 목표 금액 K를 만들기 위해 필요한 **동전 개수의 최솟값**을 구하라.
- 단, **동전의 가치들은 오름차순으로 주어지며**, K를 만드는 데 필요한 동전은 항상 존재한다.

---

## 🔍 접근 방식

- 가장 큰 가치의 동전부터 차례로 사용하면서 K를 줄여 나가는 방식의 **그리디 알고리즘**을 사용.
- 그리디 알고리즘이 적용 가능한 이유는, **동전 가치가 항상 배수 관계이기 때문**.
    - 예: 1, 5, 10, 50, 100, 500원처럼 상위 동전이 하위 동전의 배수라면, 큰 동전부터 쓰는 것이 최적이다.
- 따라서 다음과 같은 전략으로 해결 가능:
    1. 동전 배열을 내림차순 정렬
    2. 현재 금액 K에서 가장 큰 동전을 최대한 많이 사용
    3. 남은 금액에 대해 같은 방식 반복

---

## 💻 코드

```java 
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        Integer[] coins = new Integer[N];
        int count = 0;

        for(int i = 0 ; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins, Collections.reverseOrder());
        int i = 0;
        while(K > 0) {
            if(K >= coins[i]) {
               count += K / coins[i];
               K %= coins[i];
            }
            i++;
        }

        System.out.println(count);
    }
}
