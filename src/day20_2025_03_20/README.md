# 📅 2025-03-20 - 좌표 정렬하기 (백준 11650)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11650](https://www.acmicpc.net/problem/11650)
- 난이도: 실버 5
- 알고리즘 분류: 정렬

---

## 📌 문제 요약

- 2차원 좌표 N개가 주어졌을 때, 다음 기준으로 정렬하여 출력
    1. x좌표가 증가하는 순
    2. x좌표가 같으면 y좌표가 증가하는 순

---

## 🔍 접근 방식

- 좌표를 `(x, y)` 형태로 저장할 수 있는 2차원 배열을 사용
- `Arrays.sort()`와 `Comparator`를 이용해 정렬 조건을 설정
- 출력 시 정렬된 좌표를 순서대로 출력

---

## 💡 배운 점 / 회고

- 다중 정렬 조건이 필요한 경우 `Comparator` 구현이 핵심
- 2차원 배열과 사용자 정의 정렬 방식에 익숙해질 수 있는 좋은 문제
- Scanner만으로도 충분히 빠르게 처리 가능한 수준의 입력량

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
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int i = 0; i < N; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }
}
