# 📅 2025-03-15 - 문제 번호 11650 (백준 11650)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11650](https://www.acmicpc.net/problem/11650)
- 난이도: 실버 5
- 알고리즘 분류: 정렬

---

## 📌 문제 요약
- 2차원 좌표 N개가 주어진다.
- 다음 기준으로 정렬한다:
    1. x좌표 오름차순
    2. x좌표가 같으면 y좌표 오름차순

---

## 🔍 접근 방식
- `int[][]` 배열에 좌표를 저장
- `Arrays.sort()` 사용하여 정렬 기준 지정
    - `a[0] == b[0]`이면 `a[1]`과 `b[1]` 비교
    - 아니면 `a[0]`과 `b[0]` 비교

---

## 💡 배운 점 / 회고
- 2차원 배열 정렬 시 `Comparator`를 이용한 **람다식 구현 방식**을 익힐 수 있었다.
- `Integer.compare()`를 사용하면 **오버플로우 걱정 없이 안전하게 정렬** 가능하다는 걸 다시 확인했다.
- 정렬 기준이 2개일 때는 `if-else` 블럭으로 기준을 분리하면 깔끔하게 구현할 수 있었다.
- 백준 11650은 **기본 좌표 정렬의 대표 예제**로, 코딩테스트 정렬 패턴 학습에 매우 유용하다.

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
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        for (int[] point : arr) {
            System.out.println(point[0] + " " + point[1]);
        }
    }
}
