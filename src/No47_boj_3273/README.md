# 📅 두 수의 합 (백준 3273)

- 문제 링크: [https://www.acmicpc.net/problem/3273](https://www.acmicpc.net/problem/3273)
- 난이도: 실버3
- 알고리즘 분류: 투 포인터, 정렬

---

## 📌 문제 요약

정렬된 배열에서 두 수의 합이 특정 값이 되는 쌍의 개수를 구한다.

---

## 🔍 접근 방식

- 배열 정렬 후, 양 끝에 포인터를 두고 합을 비교
- `sum < target`이면 `start++`, `sum > target`이면 `end--`
- 같으면 `result++` 후 포인터 이동

---

## 💡 배운 점 / 회고

- 투 포인터 패턴이 처음엔 익숙하지 않았지만,
- 비교 조건을 명확히 하니 반복적으로 사용할 수 있는 구조임을 체감했다.
- 실무에서도 정렬 + 탐색 조합이 자주 등장하므로 익숙해질 필요가 있다.

---

## 💻 코드

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
        int sum = sc.nextInt();
        int result = 0;
        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        while(start < end) {
            int current = arr[start] + arr[end];
            if(current == sum) {
                result++;
                start++;
                end--;
            } else if(current < sum) {
                start++; // 합이 작으면 start 오른쪽으로
            } else {
                end--;   // 합이 크면 end 왼쪽으로
            }
        }

        System.out.println(result);

    }
}
