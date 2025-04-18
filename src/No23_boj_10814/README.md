# 📅 나이순 정렬 (백준 10814)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/10814](https://www.acmicpc.net/problem/10814)
- 난이도: 실버 5
- 알고리즘 분류: 정렬

---

## 📌 문제 요약

- 회원 정보가 N개 주어진다. (나이, 이름)
- 이를 **나이순으로 오름차순 정렬**하되,  
  **나이가 같으면 가입한 순서(입력 순서)**를 유지해야 한다.
- 즉, **안정 정렬(Stable Sort)**이 필요하다.

---

## 🔍 접근 방식

- 입력받은 순서를 기억하기 위해 `index` 값을 같이 저장
- `List<Member>`를 만들어서 `Comparator`로 정렬
    - `나이` 오름차순 정렬
    - 나이가 같으면 `index` 오름차순으로 유지
- `Collections.sort()`는 기본적으로 안정 정렬이 아니기 때문에,  
  **직접 기준을 명시한 Comparator**를 사용하여 구현

---

## 💡 배운 점 / 회고

- 안정 정렬이 필요한 경우에는 **기존 순서를 보존할 기준(index)**를 명시적으로 다뤄야 함
- Comparator의 `thenComparing()`을 쓰면 복합 정렬 조건을 쉽게 구현할 수 있음
- 입력이 많을 경우 `BufferedReader`와 `StringBuilder`를 활용하여 시간 최적화도 고려할 수 있다

---

## 💻 코드

```java
import java.util.*;

public class Main {
    static class Member {
        int age;
        String name;
        int index;

        Member(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new Member(age, name, i));
        }

        list.sort(Comparator.comparingInt((Member m) -> m.age)
                            .thenComparingInt(m -> m.index));

        for (Member m : list) {
            System.out.println(m.age + " " + m.name);
        }
    }
}
