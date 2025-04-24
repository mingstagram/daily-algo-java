# 📅 좌표 압축 (백준 18870)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/18870](https://www.acmicpc.net/problem/18870)
- 난이도: 실버 2
- 알고리즘 분류: 정렬, 해시, 좌표 압축

---

## 📌 문제 요약

- 수직선 위에 N개의 좌표가 주어진다.
- 좌표 압축이란, 좌표의 **상대적 크기 순서(인덱스)**를 기준으로 0부터 번호를 매겨서 치환하는 것.
- 중복된 좌표는 같은 숫자로 압축되며, 원래 순서를 유지한 채로 압축된 좌표를 출력해야 한다.

---

## 🔍 접근 방식

1. 입력 받은 좌표 배열을 복사해 `sorted` 배열 생성
2. `sorted` 배열을 정렬하고 중복을 제거한다
3. `값 → 인덱스`를 저장하는 `Map<Integer, Integer>` 생성
4. 원래 좌표 배열을 돌면서 map에서 압축된 값 출력

---

## 💡 배운 점 / 회고

- HashMap을 이용한 value → index 압축 처리 능력을 익힘
- 중복 제거 및 상대 정렬 후 맵핑하는 기본적인 "좌표 압축" 개념이 중요한 문제
- 입력/출력 속도도 고려해야 하므로 Scanner → BufferedReader, StringBuilder 사용이 추천됨

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] origin = new int[N];
        int[] sorted = new int[N];

        for (int i = 0; i < N; i++) {
            origin[i] = sc.nextInt();
            sorted[i] = origin[i];
        }

        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(origin[i])).append(" ");
        }

        System.out.println(sb.toString());
    }
}
