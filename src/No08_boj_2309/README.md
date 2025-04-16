# 📅 2025-03-09 - 일곱 난쟁이 (백준 2309)

- 문제 링크: [https://www.acmicpc.net/problem/2309](https://www.acmicpc.net/problem/2309)
- 난이도: 브론즈 1
- 알고리즘 분류: 브루트포스, 구현

---

## 📌 문제 요약

- 9명의 난쟁이 키가 주어짐
- 그 중 7명의 키의 합이 정확히 **100이 되도록** 7명을 찾아서 **오름차순으로 출력**
- 가능한 정답이 여러 개 존재하면 아무거나 출력 가능

---

## 🔍 접근 방식

- 9명 중 2명을 제외하고 나머지 7명의 키를 선택하는 **브루트포스 방식**
- `i`, `j`를 이중 루프 돌리며 제외할 2명을 고르고, 나머지 7명의 키 합이 100인지 검사
- 정답이 나오면 **라벨 루프(`loop:`)** 를 사용해 즉시 탈출
- 최종적으로 리스트를 오름차순 정렬하여 출력

---

## 💡 배운 점 / 회고

- `loop:` 라벨을 이용해 **이중 반복문을 명확히 탈출**하는 패턴을 복습함
- 문제 조건이 명확하므로 브루트포스가 오히려 깔끔하고 빠르게 적용됨
- `List.clear()`를 통해 재사용하는 방법도 실전에서 유용함
- Collections.sort() 사용해 간단히 오름차순 정렬

---

## 💻 코드

```java
package day09_2025_03_09;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrays = new int[9];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            arrays[i] = sc.nextInt();
        }

        loop:
        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                int temp = 0;
                list.clear();
                for(int k = 0; k < 9; k++) {
                    if(k != i && k != j) {
                        list.add(arrays[k]);
                        temp += arrays[k];
                    }
                }

                if(temp == 100) {
                    break loop;
                }
            }
        }

        Collections.sort(list);
        for(int item : list) {
            System.out.println(item);
        }

    }

}
