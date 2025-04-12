# 📅 2025-03-23 - 수 정렬하기 2 (백준 2751)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/2751](https://www.acmicpc.net/problem/2751)
- 난이도: 실버 5
- 알고리즘 분류: 정렬

---

## 📌 문제 요약

- N개의 수가 주어졌을 때, 이를 **오름차순으로 정렬**해서 한 줄에 하나씩 출력하는 문제

---

## 🔍 접근 방식

- 배열에 수를 입력받고 `Arrays.sort()`를 사용해 정렬
- 입력 수가 최대 1,000,000개이므로 정렬은 O(N log N) 알고리즘 필요
- 출력이 많아 `StringBuilder`를 활용해 성능 개선

---

## 💡 배운 점 / 회고

- 대용량 출력에서는 `System.out.println()` 대신 `StringBuilder` + `System.out.print()` 방식이 훨씬 빠름
- 기본형 정렬은 `Arrays.sort()`로 충분하지만, 성능이 중요한 문제에서는 입출력 최적화도 필요
- 입출력 속도가 문제 해결의 핵심인 경우, 로직보다 입출력 최적화에 더 집중해야 함

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append("\n");
        }

        System.out.print(sb);
    }
}
