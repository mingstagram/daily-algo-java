# 📅 주몽의 명령 (백준 1940)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1940](https://www.acmicpc.net/problem/1940)
- 난이도: 실버 4
- 알고리즘 분류: 정렬, 투 포인터

---

## 📌 문제 요약

- 갑옷을 만들기 위해 두 개의 재료를 선택해야 함
- 각각의 재료는 고유 번호를 가지고 있으며, **두 재료의 고유 번호 합이 M이면 갑옷을 만들 수 있음**
- N개의 재료와 M이 주어질 때, **서로 다른 두 재료로 만들 수 있는 갑옷의 개수를 출력**

---

## 🔍 접근 방식

- **투 포인터 알고리즘**을 활용하여 두 수의 합이 M이 되는 쌍을 찾음
- 먼저 재료 배열을 오름차순으로 정렬
- 배열의 양 끝에서 시작하는 두 포인터(`lt`, `rt`)를 사용
- 합이 M보다 작으면 `lt` 증가, 크면 `rt` 감소
- 합이 정확히 M이면 쌍이 성립하므로 `count++`, 그리고 `lt`, `rt` 모두 이동
- **각 재료는 한 번만 사용할 수 있으므로, 중복 없이 쌍을 세는 것이 핵심**

---

## 💡 배운 점 / 회고

- 투 포인터는 **정렬된 배열**을 순회하며 특정 합을 찾을 때 매우 유용함
- 한 재료를 한 번만 사용 가능하다는 제약 조건을 자연스럽게 반영할 수 있음
- 배열에서 두 수의 합 문제는 **해시셋 방식**과 **투 포인터 방식**으로 자주 출제되므로 두 가지 모두 익숙해질 필요가 있음
- **입력값이 크고**, 출력이 단일 정수이므로 `Scanner`와 `System.out.println`으로도 충분히 빠르게 처리 가능

---

## 💻 코드

```java
package No17_2_boj_1940;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int count = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 정렬

        int lt = 0;
        int rt = N - 1;

        while(lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum < M) {
                lt++;
            } else if (sum == M) {
                count++;
                lt++;
                rt--;
            } else {
                rt--;
            }
        }

        System.out.println(count);
    }
}
