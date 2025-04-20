# 📘 백준 1026번 - 보물

- 🔗 문제 링크: [https://www.acmicpc.net/problem/1026](https://www.acmicpc.net/problem/1026)
- 🏷️ 분류: 그리디, 정렬
- 🟢 난이도: 실버 4

---

## 📌 문제 요약

- 두 배열 A와 B가 주어진다.
- 배열 A는 재배열 가능, **B는 재배열 불가능**.
- `S = A[0]*B[0] + A[1]*B[1] + ... + A[N-1]*B[N-1]`의 값이 최소가 되도록 A를 재배열하라.

---

## 🔍 접근 방식

- 처음 문제를 보고 **"B는 재배열하면 안 된다"**는 조건 때문에 많이 헷갈렸다.
- 실제로는 **B 배열의 순서를 바꾸면 안 되지만**, A 배열의 값을 **B의 큰 값 인덱스에 대응**시키는 건 가능하다.
- 핵심 전략은 다음과 같다:
    - A는 오름차순 정렬
    - B는 값 기준 내림차순 정렬하여 곱셈에 사용 (실제 B의 순서를 출력하거나 변경하지는 않음)
    - A의 작은 값을 B의 큰 값에 곱해 최소합을 만든다

---

## ✅ 배운 점 / 회고

- "B를 재배열하지 마라"는 문장 때문에 **B를 절대 손대면 안 되는 줄** 알고 Map, Queue 등으로 복잡하게 풀려고 하다가 오히려 더 꼬였다.
- 하지만 실제 의도는 **B의 인덱스 순서를 바꾸지 말라는 것**이지, **값 기준으로 참고해 A를 배치하는 것까지 금지하는 건 아님**.
- **A의 값을 B의 큰 값 위치에 매핑**함으로써 최솟값을 만드는 게 문제의 핵심.
- 그리디 문제의 대표적인 케이스로, 조건 해석을 꼼꼼히 하는 연습이 되었다.

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A); // A는 오름차순
        Arrays.sort(B, Collections.reverseOrder()); // B는 값 기준 내림차순 (실제 순서 변경 아님)

        for (int i = 0; i < N; i++) {
            result += A[i] * B[i];
        }

        System.out.println(result);
    }
}
