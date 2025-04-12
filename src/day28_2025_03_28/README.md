# 📅 2025-03-28 - 보물 (백준 1026)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1026](https://www.acmicpc.net/problem/1026)
- 난이도: 실버 4
- 알고리즘 분류: 그리디 알고리즘, 정렬

---

## 📌 문제 요약

- 두 배열 A, B가 주어졌을 때, `A[0]×B[0] + A[1]×B[1] + ... + A[N-1]×B[N-1]`의 값을 가장 작게 만들도록 A를 재배열
- B는 재배열할 수 없음

---

## 🔍 접근 방식

- A를 오름차순 정렬하고, B는 내림차순 정렬한 복사본을 이용
- 두 배열의 각 요소를 곱해서 합산하면 최솟값을 만들 수 있음
- 실제 B 배열은 고정이므로 A만 정렬하고, B는 인덱스 기준으로 접근

---

## 💡 배운 점 / 회고

- 정렬을 활용한 그리디 전략으로, 곱의 최솟값을 만드는 기본적인 패턴
- 문제 조건에 따라 정렬 여부를 판단하고 배열을 복사해 다르게 사용할 수 있음
- 그리디 알고리즘의 직관적인 적용 예시로 자주 등장하는 유형

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        Integer[] B = new Integer[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A); // 오름차순
        Arrays.sort(B, Collections.reverseOrder()); // 내림차순

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i] * B[i];
        }

        System.out.println(sum);
    }
}
