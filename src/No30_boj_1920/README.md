# 📅 수 찾기 (백준 1920)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1920](https://www.acmicpc.net/problem/1920)
- 난이도: 실버 4
- 알고리즘 분류: 이분탐색, 자료구조

---

## 📌 문제 요약

- N개의 정수로 이루어진 집합 `A`가 주어지고,
- M개의 정수가 주어질 때, 각 정수가 집합 A에 포함되어 있는지를 **빠르게 판단**해야 한다.
- 각 수에 대해 **존재 여부(1 또는 0)**를 출력하라.

---

## 🔍 접근 방식

### ✅ 1. 이분탐색 (Binary Search)

- 집합 A를 정렬한 뒤, 각 수에 대해 이분탐색을 수행하여 존재 여부를 확인한다.
- 정렬: `O(N log N)`, 탐색: `O(log N) * M`으로 전체 시간복잡도가 매우 효율적이다.
- Java 내장 `Arrays.sort()` + 직접 구현한 `binarySearch()` 함수 사용.

### ✅ 2. HashSet (대체 가능한 방식)

- 입력받은 수를 `HashSet`에 저장하고, `.contains()`로 존재 여부 확인도 가능하다.
- 평균 시간복잡도 `O(1)`의 탐색 속도를 제공하며, 코드가 더 간결하다.
- 다만, 이 문제에서는 **이분탐색을 직접 구현해보는 것이 학습 목적상 더 적절**하다고 판단하여 이분탐색으로 풀이함.

---

## 💡 배운 점 / 회고

- 단순한 탐색 문제지만, **이분탐색 구현 연습용으로 좋은 문제**였다.
- 중간값을 기준으로 좌/우를 줄여가는 `binarySearch` 구조를 반복해서 익혀둘 필요가 있다.
- 실제 실무에서는 `HashSet`을 더 많이 쓰겠지만, **이분탐색 알고리즘을 직접 구현하고 적용해보는 것 자체가 중요한 연습**이다.

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 이분탐색 전 정렬 필수

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            sb.append(binarySearch(arr, num)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) return 1;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return 0;
    }
}
