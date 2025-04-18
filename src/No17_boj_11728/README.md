# 📅 배열 합치기 (백준 11728)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/11728](https://www.acmicpc.net/problem/11728)
- 난이도: 실버 5
- 알고리즘 분류: 정렬, 투 포인터

---

## 📌 문제 요약

- 오름차순으로 정렬된 두 배열 A, B가 주어짐
- 이 두 배열을 하나의 정렬된 배열로 합쳐서 출력
- 입력 배열의 길이는 최대 1,000,000까지 가능함

---

## 🔍 접근 방식

- 배열 A, B가 **이미 정렬된 상태**이므로, `Arrays.sort()` 같은 일반 정렬이 아니라 **투 포인터** 방식으로 병합
- A와 B를 각각 가리키는 포인터 `i`, `j`를 선언
- 두 포인터를 비교하며 더 작은 값을 출력하고, 해당 포인터를 증가시킴
- 한 배열이 끝나면 남은 배열의 값을 전부 이어붙임
- 출력은 `System.out.print` 대신 `StringBuilder`를 사용하여 성능 향상

---

## 💡 배운 점 / 회고

- 정렬된 두 배열을 병합할 때는 **병합 정렬(Merge Sort)의 병합 단계**와 같은 투 포인터 방식이 적절
- `Arrays.sort()`를 사용하면 시간복잡도가 `O((N+M)log(N+M))`이지만, 투 포인터는 `O(N+M)`으로 더 효율적
- 시간 제한이 빡빡할 경우, **출력 최적화 (StringBuilder)**도 중요한 요소가 됨
- 결국 문제의 조건(정렬됨)을 **얼마나 잘 활용하느냐**가 핵심!

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] arrays_A = new long[N];
        long[] arrays_B = new long[M];

        for (int i = 0; i < N; i++) {
            arrays_A[i] = sc.nextLong();
        }

        for (int i = 0; i < M; i++) {
            arrays_B[i] = sc.nextLong();
        }

        int i = 0;
        int j = 0;

        while (i < arrays_A.length && j < arrays_B.length) {
            if (arrays_A[i] <= arrays_B[j]) {
                sb.append(arrays_A[i]).append(" ");
                i++;
            } else {
                sb.append(arrays_B[j]).append(" ");
                j++;
            }
        }

        while (i < arrays_A.length) {
            sb.append(arrays_A[i]).append(" ");
            i++;
        }

        while (j < arrays_B.length) {
            sb.append(arrays_B[j]).append(" ");
            j++;
        }

        System.out.println(sb.toString());
    }
}
