# 📅 로또 (백준 6603)

- 문제 링크: [https://www.acmicpc.net/problem/6603](https://www.acmicpc.net/problem/6603)
- 난이도: 실버 2
- 알고리즘 분류: 백트래킹, 브루트포스, 조합

---

## 📌 문제 요약

- 집합 S에서 **6개 숫자를 고르는 모든 조합**을 구하는 문제
- 입력은 여러 줄로 들어오며, 각 줄의 첫 숫자 `k`는 집합의 원소 수
- `k`개의 숫자 뒤에는 S의 원소들이 주어짐 (오름차순)
- `0`이 입력되면 종료
- 각 테스트 케이스마다 공백 한 줄로 구분하여 출력해야 함

---

## 🔍 접근 방식

- **백트래킹 조합 템플릿** `dfs(depth, start)` 패턴 사용
- `selected[]` 배열에 뽑은 숫자 6개를 저장
- `start` 인자를 넘겨줌으로써 **중복 없이 오름차순 조합 생성**
- 입력은 `while(true)`로 처리하며, `k == 0`이면 종료
- 테스트 케이스 사이에는 `System.out.println()`으로 공백 한 줄 출력

---

## 💡 배운 점 / 회고

- 조합 문제는 `visited` 없이도 `start` 인자로만 중복 제거 가능하다는 점 다시 확인
- 입력 케이스가 여러 개일 경우, **while 루프 + 종료 조건** 패턴을 익힘
- 백트래킹 재귀 구조가 완전히 익숙해졌고, **문제마다 공통되는 틀**을 잡는 감이 생김
- 단순 조합 생성에서 입력 처리, 출력 포맷까지 고려해야 한다는 것도 체감

---

## 💻 코드

```java

import java.util.*;

public class Main {

    static int k;
    final static int m = 6; // 로또 추첨 6개 고정
    static int[] selected;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            k = sc.nextInt();
            if(k == 0) break;
            arr = new int[k];
            selected = new int[m];
            for(int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            dfs(0, 0);
            System.out.println();
        }
    }

    static void dfs(int depth, int start) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < k; i++) {
            selected[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }

    }

}
