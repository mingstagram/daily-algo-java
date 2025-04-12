# 📅 2025-03-25 - 한수 (백준 1065)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1065](https://www.acmicpc.net/problem/1065)
- 난이도: 실버 5
- 알고리즘 분류: 수학, 브루트포스

---

## 📌 문제 요약

- 1 이상 N 이하의 자연수 중에서 **각 자릿수가 등차수열을 이루는 수**의 개수를 구하는 문제

---

## 🔍 접근 방식

- N이 100보다 작거나 같으면 모두 한수이므로 바로 카운트
- 100보다 큰 수는 각 자릿수를 분리해 등차 여부 확인
- 등차수열 조건: 각 자리의 차가 일정해야 함 → `a - b == b - c`
- 반복문을 통해 1부터 N까지 검사하며 조건을 만족하면 카운트 증가

---

## 💡 배운 점 / 회고

- 자릿수 계산을 수학적으로 직접 처리하거나 문자열로 변환하는 방식 모두 가능
- 100 이상 숫자부터 조건 검사 시 예외 없이 정확하게 나눠서 처리해야 함
- 작은 범위의 수에 대해 직접 조건 검사하는 방식은 성능 부담 없이 구현 가능

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (isHansu(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isHansu(int num) {
        if (num < 100) return true;

        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num % 10;

        return (a - b) == (b - c);
    }
}
