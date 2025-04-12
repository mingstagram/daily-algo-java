# 📅 2025-04-09 - N과 M (4) (백준 15652)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/15652](https://www.acmicpc.net/problem/15652)
- 난이도: 실버 3
- 알고리즘 분류: 백트래킹

---

## 📌 문제 요약

- 1부터 N까지 자연수 중에서 **중복을 허용**하면서 **비내림차순(오름차순 허용)** 으로 M개를 고른 모든 수열을 출력하는 문제

---

## 🔍 접근 방식

- 중복을 허용하되 비내림차순 조건을 만족해야 하므로 `start` 인덱스를 유지
- `visited` 배열은 필요 없음
- 매 깊이마다 현재 수 이상부터 반복하여 수열을 구성

---

## 💡 배운 점 / 회고

- 중복 허용과 오름차순 조건을 동시에 만족시킬 때는 `start` 인덱스를 유지하는 방식이 효과적
- 비내림차순 조건은 조합과 유사하지만 같은 수를 여러 번 선택할 수 있다는 점이 다름
- 출력 최적화를 위해 `StringBuilder` 사용은 필수

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

        dfs(0, 1);
        System.out.print(sb);
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            result[depth] = i;
            dfs(depth + 1, i); // 중복 허용 → i부터 다시 시작
        }
    }
}
