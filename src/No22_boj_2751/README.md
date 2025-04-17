# 📅 2025-03-16 - 문제 번호 2751 (백준 2751)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/2751](https://www.acmicpc.net/problem/2751)
- 난이도: 실버 5
- 알고리즘 분류: 정렬, 입출력 최적화

---

## 📌 문제 요약
- N개의 수가 주어진다. (1 ≤ N ≤ 1,000,000)
- 이 수들을 **오름차순으로 정렬**해서 한 줄에 하나씩 출력하라.

---

## 🔍 접근 방식
- 일반적으로는 `Scanner + Arrays.sort()`로 충분할 것 같지만, ❗**시간 초과 발생**
- **병목 원인**은 `Scanner`와 `System.out.println()`으로 인한 **느린 입출력 처리**

### 🔑 해결 전략
- 입력: `BufferedReader`
- 출력: `BufferedWriter` 또는 `StringBuilder`
- 정렬: `Arrays.sort(int[])` 사용 (Dual Pivot Quick Sort)

---

## 💡 배운 점 / 회고
- 단순히 정렬 알고리즘만 정확하면 끝날 줄 알았지만, **입출력 속도도 알고리즘 효율만큼 중요하다는 걸 체감**했다.
- `Scanner`와 `System.out.println()`은 작을 때 편하지만, 대규모 데이터에는 적합하지 않다.
- `BufferedReader`와 `BufferedWriter`는 대용량 입력/출력 시 거의 필수임을 알게 됐다.
- **정렬 문제 같지만 사실상 IO 튜닝 연습 문제**였다.
- 알고리즘 문제를 풀 때는 **입력 크기와 시간복잡도 외에도 "출력 방식"도 고려해야 함**을 기억하자!

---

## 💻 코드

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빠른 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);  // O(n log n)

        for (int num : arr) {
            bw.write(num + "\n");
        }

        bw.flush();
        bw.close();
    }
}
