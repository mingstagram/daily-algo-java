# 📅 약수 (백준 1037)

- 문제 링크: [https://www.acmicpc.net/problem/1037](https://www.acmicpc.net/problem/1037)
- 난이도: 실버 4
- 알고리즘 분류: 수학, 정수론

---

## 📌 문제 요약

- 어떤 자연수 N이 있을 때, 그 수의 진짜 약수(1과 N 제외)가 주어짐.
- 이 약수들을 이용해 N을 구하는 문제.
- 단, 약수의 리스트는 중복되지 않고, 오름차순/내림차순으로 주어지지 않을 수도 있음.

---

## 🔍 접근 방식

- **약수는 항상 "최소값 × 최대값"** 이 N이 된다.
- 이유: 최소 진약수와 최대 진약수의 곱이 항상 원래 수(N)가 되기 때문.
- 입력이 하나만 들어오는 경우(진약수가 하나뿐인 경우)는,  
  `N = 약수 × 약수` 가 된다. (예: 약수 7 → 7×7=49)

---

## 💡 배운 점 / 회고

- 진약수가 주어졌을 때는 **최소 × 최대** 로 쉽게 원래 수를 구할 수 있다는 패턴을 학습했다.
- 문제에서 "진짜 약수"만 주어진다는 조건을 정확히 읽는 것이 중요했다.
- 배열 정렬 후 양 끝 값을 곱하는 방법으로 매우 간단하게 해결할 수 있었다.
- 예외 케이스(약수가 1개일 때)를 조건문으로 잘 처리하는 것도 포인트였다.

---

## 💻 Java 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = (n == 1) ? arr[0] * arr[0] : arr[0] * arr[n - 1];
        System.out.println(answer);
    }
}
