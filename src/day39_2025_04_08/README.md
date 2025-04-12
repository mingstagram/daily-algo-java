# 📅 2025-04-08 - N과 M (3) (백준 15651)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/15651](https://www.acmicpc.net/problem/15651)
- 난이도: 실버 3
- 알고리즘 분류: 백트래킹

---

## 📌 문제 요약

- 1부터 N까지 자연수 중에서 **중복을 허용하여** M개를 고른 모든 수열을 출력하는 문제
- 사전 순으로 출력해야 함

---

## 🔍 접근 방식

- 중복을 허용하므로 `visited` 배열 없이 구현
- `dfs` 함수에서 매 깊이마다 1부터 N까지 반복하여 선택
- 선택된 수열은 `result` 배열에 저장하고, M개가 되면 출력

---

## 💡 배운 점 / 회고

- **중복 허용**과 **중복 불가** 조건의 차이를 구조적으로 구분하여 익힐 수 있음
- 매 탐색마다 모든 수를 사용할 수 있으므로 반복문 범위는 항상 1부터 N까지
- 수열 출력 문제에서 시간 초과 방지를 위해 `StringBuilder` 활용은 필수적임

---

## 💻 코드

```java
import java.util.*;

public class Main {
    static int N, M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];

        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            result[depth] = i;
            dfs(depth + 1);
        }
    }
}
