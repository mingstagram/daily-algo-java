# 📅 소트인사이드 (백준 1427)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1427](https://www.acmicpc.net/problem/1427)
- 난이도: 실버 5
- 알고리즘 분류: 정렬, 수학, 문자열

---

## 📌 문제 요약

- 하나의 정수 N이 주어진다.
- N의 **각 자릿수를 큰 수부터 작은 수로 정렬한 결과**를 출력하라.

---

## 🔍 접근 방식

- 입력값 N을 숫자 그대로 받아서 자릿수를 분해 (`% 10` 방식)
- 각 자릿수를 리스트에 넣고 `Collections.sort()`로 내림차순 정렬
- 리스트를 순회하며 하나의 숫자처럼 출력

---

## 💡 배운 점 / 회고

- 자릿수 분해는 문자열로 바꾸지 않고 `% 10`, `/= 10`으로 처리 가능
- 내림차순 정렬 시 `Collections.reverseOrder()`를 쓰면 직관적이고 간단함
- 출력 시 `System.out.print()`를 활용해 줄바꿈 없이 출력 처리
- 문자열 방식(`String.toCharArray()`)과 수학적 방식(`%`) 중 상황에 따라 선택 가능

---

## 💻 코드

```java
package No21_boj_1427;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        while (N > 0) {
            list.add(N % 10);
            N /= 10;
        }

        Collections.sort(list, Collections.reverseOrder());
        list.forEach(System.out::print);
    }
}
