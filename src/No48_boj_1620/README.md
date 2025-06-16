# 📅 나는야 포켓몬 마스터 이다솜 (백준 1620)

- 문제 링크: [https://www.acmicpc.net/problem/1620](https://www.acmicpc.net/problem/1620)
- 난이도: 실버4
- 알고리즘 분류: 자료구조, 해시맵, 문자열 처리

---

## 📌 문제 요약

- 총 N개의 포켓몬이 이름과 함께 번호(1 ~ N)를 가짐
- 질의 M개가 주어짐
    - 포켓몬 이름을 주면 번호를 출력
    - 번호를 주면 포켓몬 이름을 출력
- 이름 ↔ 번호 양방향 조회를 **빠르게 처리**해야 함

---

## 🔍 접근 방식

- `Map<String, Integer> nameToNum`: 이름 → 번호 조회용
- `Map<Integer, String> numToName`: 번호 → 이름 조회용
- N개의 포켓몬 등록 시 두 맵에 동시에 저장
- 질의가 주어졌을 때, 입력값이 숫자인지 문자열인지 판별 필요

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> numToName = new HashMap<>();
        Map<String, Integer> nameToNum = new HashMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            String name = sc.next();
            nameToNum.put(name, i);
            numToName.put(i, name);
        }

        for(int i = 0; i < m; i++) {
            String question = sc.next();
            if(isNumeric(question)) {
                // 정수형인경우
                int q = Integer.parseInt(question);
                System.out.println(numToName.get(q));
            } else {
                // 문자열인경우
                System.out.println(nameToNum.get(question));
            }
        }

    }

    static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
