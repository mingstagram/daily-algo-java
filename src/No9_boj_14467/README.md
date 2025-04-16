# 📅 2025-03-10 - 소가 길을 건너간 이유 1 (백준 14467)

- 문제 링크: [https://www.acmicpc.net/problem/14467](https://www.acmicpc.net/problem/14467)
- 난이도: 브론즈 1
- 알고리즘 분류: 구현, 시뮬레이션, 해시

---

## 📌 문제 요약

- 소 10마리에 대해 관찰 기록이 주어짐
- 각 줄은 `(소 번호, 위치)`로 이루어짐 (위치는 0 또는 1)
- **같은 소가 이전과 다른 위치로 나타나면 ‘길을 건넌 것’으로 간주**
- 소가 최소 몇 번 길을 건넜는지를 계산

---

## 🔍 접근 방식

- 각 소의 **이전 위치를 저장**하고, 현재 위치와 비교
- 이전에 관찰된 적이 없으면 저장만 하고 넘어감
- **위치가 달라졌을 경우에만 count 증가**
- Map 또는 배열을 이용한 상태 추적 방식 사용 가능

---

## 💡 배운 점 / 회고

- 상태 변경을 감지하는 문제는 **기록/기억을 유지하는 자료구조(Map 또는 배열)**를 적절히 활용하면 쉽게 해결 가능
- 제한된 데이터(소 10마리)인 경우, **배열 기반 최적화도 고려 가능**
- `HashMap`의 기본 사용법 숙지 및 `get`과 `put` 조합 연습하기에 좋은 문제

---

## 💻 코드

```java
package day10_2025_03_10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < N; i++) {
            int cow = sc.nextInt();
            int location = sc.nextInt();
            if(map.containsKey(cow)) {
                if(map.get(cow) != location) {
                    count++;
                }
            }
            map.put(cow, location);
        }
        System.out.println(count);
    }
}
