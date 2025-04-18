# 📅 2025-03-15 - 문제 번호 11651 (백준 11651)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11651](https://www.acmicpc.net/problem/11651)
- 난이도: 실버 5
- 알고리즘 분류: 정렬

---

## 📌 문제 요약
- 2차원 좌표 N개가 주어진다.
- 다음 기준으로 정렬한다:
    1. y좌표 오름차순
    2. y좌표가 같으면 x좌표 오름차순

---

## 🔍 접근 방식
- `int[][]` 배열에 좌표를 저장
- `Arrays.sort()` 사용하여 정렬 기준 지정
    - `a[1] == b[1]`이면 `a[0]`과 `b[0]` 비교
    - 아니면 `a[1]`과 `b[1]` 비교

---

## 💡 배운 점 / 회고
- 11650과 거의 동일한 구조지만, **정렬 기준 순서가 바뀐 것**만 주의하면 되는 문제.
- Comparator 내 조건 분기만 수정해서 쉽게 구현 가능.
- 실무 또는 알고리즘 문제에서도 흔히 쓰이는 **복수 기준 정렬 패턴**을 연습할 수 있었음.
- 좌표 정렬 문제는 정렬 기준을 "어떤 순서로 먼저 적용할지"를 정확히 파악하는 것이 핵심이다.

---

## 💻 코드
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int[] point : arr) {
            System.out.println(point[0] + " " + point[1]);
        }
    }
}