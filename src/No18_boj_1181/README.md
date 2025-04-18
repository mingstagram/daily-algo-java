# 📅 문제 번호 1181 (백준 1181)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/1181](https://www.acmicpc.net/problem/1181)
- 난이도: 실버 5
- 알고리즘 분류: 정렬, 문자열

---

## 📌 문제 요약
- 단어 N개가 주어진다.
- 다음 조건으로 정렬해서 출력하라:
    1. 길이가 짧은 것부터
    2. 길이가 같으면 사전순
    3. 중복 단어는 제거

---

## 🔍 접근 방식
- **Set<String>**을 사용하여 중복을 제거함
- 중복 제거된 단어들을 **List<String>**으로 변환 후 정렬
- 정렬 기준:
    - `Comparator.comparingInt(String::length)` → 길이 오름차순
    - `.thenComparing(s -> s)` → 길이가 같을 경우 사전순
- 정렬된 리스트를 순회하며 출력

---

## 💡 배운 점 / 회고
- `Set`을 사용하면 간단하게 **중복 제거**가 가능하다는 점을 다시 확인했다.
- `Comparator` 체이닝을 통해 **다중 정렬 기준**을 효과적으로 적용할 수 있었다.
- `thenComparing(s -> s)`는 곧 **사전순 정렬**과 같다는 점이 흥미로웠다.
- 처음엔 `Map<String, Integer>`로 길이를 직접 저장했지만, `Set`과 정렬 함수만으로도 충분히 문제를 해결할 수 있다는 점에서 **더 간결한 코드로 리팩토링하는 연습**이 됐다.
- 앞으로도 **정렬 조건이 복수일 경우 Comparator 체이닝을 적극 활용**해야겠다.

---

## 💻 코드
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        List<String> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(String::length).thenComparing(s -> s));

        for (String s : list) {
            System.out.println(s);
        }
    }
}
