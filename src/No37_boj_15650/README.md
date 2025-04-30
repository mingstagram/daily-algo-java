# 📅 N과 M (2) (백준 15650)

- 문제 링크: [https://www.acmicpc.net/problem/15650](https://www.acmicpc.net/problem/15650)
- 난이도: 실버 3
- 알고리즘 분류: 백트래킹, 브루트포스, 조합

---

## 📌 문제 요약

- 1부터 N까지 자연수 중에서 **중복 없이 M개를 고른 조합**을 모두 구하는 문제
- 각 수열은 오름차순으로 출력해야 하며, **숫자 중복은 불가능**
- 결과는 사전 순으로 자동 정렬됨 (오름차순 탐색 조건만 지키면 됨)

---

## 🔍 접근 방식

- **백트래킹(DFS)** 방식으로 M개의 숫자를 재귀적으로 선택
- 매 재귀 호출 시 시작 숫자를 인자로 넘겨, **이전 숫자보다 큰 수만 탐색**하게 구성
- `visited` 배열 없이 `start` 파라미터로 **중복 방지 + 오름차순 유지**
- 핵심은 `dfs(depth, start)` → 선택된 수 저장 → 다음 자리엔 `start+1`부터 선택

---

## 💡 배운 점 / 회고

- 조합 문제는 `visited` 없이도 **시작 지점을 제한(start)** 하면 훨씬 깔끔하게 해결할 수 있다
- 순열과 조합의 차이점(순서 중요 vs 순서 무관)을 직접 구현하며 감각적으로 익힘
- 백트래킹은 재귀 흐름만 잘 익히면 다양한 조건 조합도 응용 가능하다
- `dfs(depth, start)` 구조는 **조합형 문제의 공식 템플릿**처럼 활용 가능

---

## 💻 코드

```java
package No37_boj_15650;

import java.util.*;

public class Main {

    static int n, m;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        m = sc.nextInt(); 
        selected = new int[m];

        dfs(0, 1); // depth 0부터 시작, 시작 숫자는 1부터
    }

    static void dfs(int depth, int start) {
        if (depth == m) {
            for (int num : selected) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            selected[depth] = i;  
            dfs(depth + 1, i + 1); 
        }
    }
}
