# 📅  문자열 집합 (백준 14425)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/14425](https://www.acmicpc.net/problem/14425)
- 난이도: 실버 3
- 알고리즘 분류: 자료구조, 문자열, 해시

---

## 📌 문제 요약

- 문자열로 구성된 집합 S가 주어짐 (N개)
- 입력으로 주어지는 문자열 M개 중에서 **집합 S에 포함된 문자열**이 총 몇 개인지 출력
- 단어는 정확히 일치해야 포함으로 간주되며, 부분 문자열은 포함되지 않음

---

## 🔍 접근 방식

- 집합 S는 문자열의 존재 여부를 빠르게 확인할 수 있도록 `HashSet`으로 구성
- 검사 대상 문자열들을 하나씩 입력받아 `set.contains(s)`로 포함 여부 체크
- 포함되어 있다면 카운트를 증가시켜 최종 결과 출력
- `HashSet`을 사용함으로써 시간 복잡도는 평균적으로 **O(1)**의 탐색 성능 확보

---

## 💡 배운 점 / 회고

- 단순 배열이나 리스트로는 탐색 시 O(N)의 시간복잡도가 발생하여 시간 초과가 날 수 있음
- `HashSet`은 해시 기반 자료구조로서 빠른 탐색이 가능하여 **"존재 여부 확인"** 문제에 매우 적합함
- 문제에서 "정확히 일치하는 문자열만 포함"이라는 조건이 있으므로, equals() 기반 탐색이 되는 Set이 가장 이상적인 선택
- 시간 복잡도뿐 아니라 **문제 조건에 가장 자연스럽게 매칭되는 자료구조를 선택하는 것이 중요하다는 교훈**

---

## 💻 코드

```java
package day07_2025_04_14;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Set<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        for (int i = 0; i < M; i++) {
            String s = sc.next();
            if (set.contains(s)) count++;
        }

        System.out.println(count);
    }
}
