# 📅 한수 (백준 1065)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1065](https://www.acmicpc.net/problem/1065)
- 난이도: 브론즈2
- 알고리즘 분류: 구현, 수학

---

## 📌 문제 요약

- 1 이상 N 이하의 정수 중, 각 자릿수가 등차수열을 이루는 숫자를 **한수**라고 한다.
- 1~99는 모두 한수이며, 100 이상부터는 각 자릿수의 차이를 비교하여 판단한다.
- N 이하의 한수의 개수를 구하는 문제이다.

---

## 🔍 접근 방식

- `N <= 99`이면 그대로 N 출력 (모두 한수)
- `N > 99`일 경우, 1부터 N까지 순회하면서 각 수가 한수인지 `isHansu()` 함수로 판단
- `isHansu()`에서는 3자리 수의 각 자릿수를 나눠 공차가 동일한지 비교

---

## 💡 배운 점 / 회고

- 자릿수를 분리하여 수학적인 조건을 직접 구현해보는 연습이 됐다.
- 반복문 내부 로직을 함수로 분리하여 **가독성과 유지보수성**을 높이는 것이 효과적임을 느꼈다.
- 자릿수 분해 시 `%`, `/` 연산을 이용한 방식이 익숙해졌다.

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= Math.min(N, 999); i++) {
            if (isHansu(i)) count++;
        }

        System.out.println(count);
    }

    public static boolean isHansu(int num) {
        if (num < 100) return true;

        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num % 10;

        return (a - b) == (b - c);
    }
}
