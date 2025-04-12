# 📅 2025-03-27 - 그룹 단어 체커 (백준 1316)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1316](https://www.acmicpc.net/problem/1316)
- 난이도: 실버 5
- 알고리즘 분류: 구현, 문자열

---

## 📌 문제 요약

- 입력으로 주어진 단어 N개 중에서 **그룹 단어**의 개수를 구하는 문제
- 그룹 단어: 같은 문자가 연속해서 나타나는 경우 외에는 중간에 다른 문자가 끼어들지 않아야 함

---

## 🔍 접근 방식

- 각 단어마다 이전 문자를 추적하면서 등장한 문자를 체크
- 한 번 등장한 문자가 다시 등장할 경우, 직전 문자와 동일하지 않으면 그룹 단어가 아님
- 알파벳 방문 여부는 boolean 배열(26길이)을 사용

---

## 💡 배운 점 / 회고

- 문자열 순회 시 **이전 문자와 현재 문자를 비교**하는 로직이 자주 활용됨
- 방문 체크용 배열을 사용할 경우 인덱스 계산(`c - 'a'`) 패턴은 기억해둘 만함
- 문자열 조건 검사는 문제 의도를 정확히 이해하고 구현하는 것이 가장 중요

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            if (isGroupWord(word)) count++;
        }

        System.out.println(count);
    }

    private static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26];
        char prev = word.charAt(0);
        visited[prev - 'a'] = true;

        for (int i = 1; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (curr != prev) {
                if (visited[curr - 'a']) {
                    return false;
                }
                visited[curr - 'a'] = true;
                prev = curr;
            }
        }

        return true;
    }
}
