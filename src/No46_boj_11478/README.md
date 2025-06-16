# 📅 서로 다른 부분 문자열의 개수 (백준 11478)

- 문제 링크: [https://www.acmicpc.net/problem/11478](https://www.acmicpc.net/problem/11478)
- 난이도: 실버 3
- 알고리즘 분류: 문자열, 해시, 집합(Set), 브루트포스

---

## 📌 문제 요약

- 문자열 `S`가 주어질 때,
- `S`의 모든 **부분 문자열(substring)** 중 **서로 다른 것의 개수**를 구하는 문제
- 부분 문자열: 문자열에서 연속된 일부 문자들을 추출한 문자열

---

## 🔍 접근 방식

- 문자열의 **모든 부분 문자열을 탐색**하면서 `HashSet`에 저장
- 중복 제거된 문자열들만 `Set`에 남게 됨
- 마지막에 `Set.size()`를 출력하면 **서로 다른 부분 문자열 개수**가 됨
- 시간복잡도는 O(N²)지만, 문자열 길이가 최대 1000이라서 문제 없음

---

## 💡 배운 점 / 회고

- `HashSet`을 이용해서 중복을 쉽게 제거할 수 있었음
- 부분 문자열의 개수는 O(N²)이라 시간 복잡도 고려가 필요하지만, 이번 문제에선 충분히 통과됨
- 나중에 접미사 배열 + LCP 방식도 공부해두면 더 큰 입력에서도 빠르게 해결 가능할 것 같음
- 문자열 문제를 풀 때 **substring() 범위 조심하기**!

---

## 💻 코드

```java 
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int length = S.length();
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= length; i++) { // 부분 문자열 길이
            for (int j = 0; j <= length - i; j++) { // 시작 인덱스
                set.add(S.substring(j, j + i)); // 부분 문자열을 Set에 저장
            }
        }
        System.out.println(set.size()); // 서로 다른 부분 문자열 개수 출력
    }
}
