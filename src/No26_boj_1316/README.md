# 📅 그룹 단어 체커 (백준 1316)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1316](https://www.acmicpc.net/problem/1316)
- 난이도: 실버5
- 알고리즘 분류: 문자열, 구현

---

## 📌 문제 요약

- **그룹 단어**란, 어떤 문자가 연속해서 등장하고, **중간에 끊기지 않아야 하는 단어**를 말한다.
- 예시:
    - `ccazzzzbb` → 그룹 단어 (문자들이 연속 등장)
    - `aabbaa` → 그룹 단어 아님 (a가 떨어져서 등장함)
- N개의 단어가 주어질 때, 그 중 **그룹 단어의 개수**를 출력하는 문제.

---

## 🔍 접근 방식

- 알파벳 소문자 수는 26개 → `boolean[26]` 배열로 방문 여부 체크
- 첫 문자는 무조건 방문 처리
- 그 이후부터는:
    - **이전 문자와 다르면서 이미 등장한 문자라면** → 그룹 단어가 아님
    - 처음 등장한 문자는 `visited`에 마킹
- 모든 조건을 통과한 경우만 그룹 단어로 인정

---

## 💡 배운 점 / 회고

- `prev`를 따로 쓰지 않고 `j - 1`을 활용해 비교하면서 더 간결하게 구성할 수 있었다.
- 처음 문자 처리(`j == 0`)를 놓치면 오답이 되는 대표적인 예시였다.
- 단순 문자열 문제처럼 보이지만, **방문 마킹 + 이전 문자 비교**라는 DFS 스타일 로직을 접목할 수 있는 문제였다.
- `HashMap`보다 `boolean[26]` 배열이 훨씬 빠르고 간단하다는 점도 실전에서 유리하다고 느꼈다.

---

## 💻 코드

```java
package No26_boj_1316;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            boolean[] visited = new boolean[26];
            boolean isChecked = true;

            for (int j = 0; j < word.length(); j++) {
                char current = word.charAt(j);
                if (j == 0) {
                    visited[current - 'a'] = true;
                    continue;
                }

                if (current != word.charAt(j - 1)) {
                    if (visited[current - 'a']) {
                        isChecked = false;
                        break;
                    }
                    visited[current - 'a'] = true;
                }
            }

            if (isChecked) count++;
        }

        System.out.println(count);
    }
}
