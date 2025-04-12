# 📅 2025-03-19 - 단어 정렬 (백준 1181)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1181](https://www.acmicpc.net/problem/1181)
- 난이도: 실버 5
- 알고리즘 분류: 문자열, 정렬

---

## 📌 문제 요약

- 알파벳 소문자로 이루어진 단어 N개가 주어졌을 때, 중복을 제거하고 정렬해야 함
- 정렬 기준:
    1. 길이가 짧은 순
    2. 길이가 같으면 사전 순

---

## 🔍 접근 방식

- 입력 단어를 `Set`으로 받아 중복 제거
- 리스트로 변환 후 `Collections.sort()`와 `Comparator`를 사용해 조건에 맞게 정렬
- 정렬 기준은 `Comparator`를 통해 길이 → 알파벳 순서대로 설정

---

## 💡 배운 점 / 회고

- 정렬 기준이 두 가지 이상일 경우 `Comparator`의 `thenComparing()` 또는 람다 표현식을 적절히 사용하는 것이 중요
- `Set`을 이용한 중복 제거 후 정렬하는 패턴은 자주 등장하므로 익숙해지는 것이 좋음
- `BufferedReader`를 이용하면 입력 속도도 개선 가능

---

## 💻 코드

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);
        list.sort((a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : list) {
            sb.append(word).append("\n");
        }

        System.out.print(sb);
    }
}
