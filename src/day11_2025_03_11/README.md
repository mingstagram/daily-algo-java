# 📅 2025-03-11 - 더하기 사이클 (백준 1110)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1110](https://www.acmicpc.net/problem/1110)
- 난이도: 브론즈 1
- 알고리즘 분류: 수학, 구현

---

## 📌 문제 요약

- 정수 N이 주어졌을 때 다음과 같은 과정을 반복하여 **처음으로 돌아오는 횟수**를 출력해야 함.

### 🔁 변환 규칙
1. N의 **각 자리 숫자를 더함**
2. N의 **1의 자리 수**와 **위에서 더한 합의 1의 자리 수**를 이어 붙여 새로운 수 생성
3. 이 과정을 반복하다가 **처음 입력받은 수로 돌아오면 반복 횟수 출력**

📌 예시  
입력: 26 →  
2 + 6 = 8 → 68 →  
6 + 8 = 14 → 84 →  
8 + 4 = 12 → 42 →  
4 + 2 = 6 → 26 →  
➡ 총 **4번**만에 원래 수로 돌아옴

---

## 🔍 접근 방식

- 입력값을 그대로 저장해두고 `do-while` 루프를 통해 반복
- 매 반복마다:
    - 십의 자리, 일의 자리 분리
    - 합산 후 새로운 수 계산
    - 반복 횟수 증가
- **새로운 수가 처음 수와 같아질 때까지** 반복

---

## 💡 배운 점 / 회고

- 단순 반복 + 수학적 연산 조합으로 구성된 구현 문제
- 각 자리수를 분리하고 다시 조합하는 로직을 자연스럽게 익힐 수 있음
- `do-while`은 최소 1번 이상 실행되는 조건에서 특히 유용함

---

## 💻 코드

```java
package day08_2025_04_15;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int original = N;
        int count = 0;

        do {
            int tens = N / 10;
            int ones = N % 10;
            int sum = tens + ones;
            N = (ones * 10) + (sum % 10);
            count++;
        } while (N != original);

        System.out.println(count);
    }
}
