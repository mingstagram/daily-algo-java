# 📅 2025-03-21 - 좌표 정렬하기 2 (백준 11651)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11651](https://www.acmicpc.net/problem/11651)
- 난이도: 실버 5
- 알고리즘 분류: 정렬

---

## 📌 문제 요약

- 2차원 좌표 N개가 주어졌을 때, 다음 기준으로 정렬하여 출력
    1. y좌표가 증가하는 순
    2. y좌표가 같으면 x좌표가 증가하는 순

---

## 🔍 접근 방식

- 좌표를 (x, y) 형태로 저장한 뒤, `Arrays.sort()`를 사용해 조건에 맞게 정렬
- Comparator에서 y 기준 → x 기준 순으로 비교 수행
- 정렬된 좌표를 순서대로 출력

---

## 💡 배운 점 / 회고

- 문제 11650과 유사하지만 정렬 기준만 다름
- 다중 조건 정렬 시 Comparator를 활용해 정렬 기준 순서를 정확히 정의하는 것이 중요
- 정렬 조건만 바꿔도 완전히 다른 결과가 나올 수 있으므로 조건 분석이 핵심

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextInt(); // x
            points[i][1] = sc.nextInt(); // y
        }

        Arrays.sort(points, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < N; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }
}
