# 📅 숫자 카드 2 (백준 10816)

- 문제 링크: [https://www.acmicpc.net/problem/10816](https://www.acmicpc.net/problem/10816)
- 난이도: 실버4
- 알고리즘 분류: 자료구조, 해시맵, 이분 탐색 (Java 기준 해시맵 풀이)

---

## 📌 문제 요약

- 숫자 카드 N개가 주어지고
- M개의 정수에 대해 **각 정수가 몇 개의 카드로 존재하는지 출력**해야 한다.
- 중복된 숫자가 있을 수 있으며, 빠르게 개수를 조회해야 함

---

## 🔍 접근 방식

- `Map<Integer, Integer>`를 사용해 카드 숫자의 **빈도수(개수)**를 카운트
- 질의 숫자 하나하나에 대해 `getOrDefault(key, 0)` 으로 개수를 빠르게 조회
- **카운트용 Map과 질의용 입력을 분리하여 처리**

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int item = sc.nextInt();
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int item = sc.nextInt();
            sb.append(map.getOrDefault(item, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
