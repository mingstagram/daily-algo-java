# 📅 회사에 있는 사람 (백준 7785번)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/7785](https://www.acmicpc.net/problem/7785)
- 난이도: ⭐️⭐️ (실버5)
- 알고리즘 분류: 자료구조, 해시셋, 정렬

---

## 📌 문제 요약

- 로그 기록이 주어진다: "이름 enter" 또는 "이름 leave"
- 출근한 사람은 enter, 퇴근한 사람은 leave로 기록된다.
- 현재 회사에 남아있는 사람의 이름을 **사전 역순(내림차순)** 으로 출력하라.

---

## 🔍 접근 방식

- **HashSet**을 사용하여 입장/퇴장 상태를 기록함
    - `enter` → `set.add(name)`
    - `leave` → `set.remove(name)`
- 최종적으로 Set에 남아 있는 사람을 리스트로 변환한 후,
- `Collections.sort(list, Collections.reverseOrder())`로 **사전 역순 정렬**
- 순서대로 출력

---

## 💡 배운 점 / 회고

- 단순 입퇴장 상태 추적에는 `HashSet`이 가장 적절하다는 걸 다시 체감함.
- 정렬 기준이 "사전 역순"이라는 조건에 주의할 것.
- 나중에 Stream + Comparator를 활용하면 코드도 더 간결하게 작성 가능할 듯.

---

## 💻 코드

```java 
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            String name = sc.next();
            String action = sc.next();

            if(action.equals("enter")) {
                set.add(name);
            } else if(action.equals("leave")) {
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        for(String name : list) {
            System.out.println(name);
        }
    }
}