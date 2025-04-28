# 📅 괄호 (백준 9012)

- 문제 링크: [https://www.acmicpc.net/problem/9012](https://www.acmicpc.net/problem/9012)
- 난이도: 실버 4
- 알고리즘 분류: 자료구조, 스택, 문자열

---

## 📌 문제 요약

- 괄호 문자열(PS)이 주어졌을 때, 올바른 괄호 문자열(VPS)인지 판별하는 문제.
- 올바른 괄호 문자열이란:
    - '('와 ')'의 짝이 모두 맞고,
    - 중간에 ')'가 먼저 나오는 경우가 없는 문자열.

- 입력: 테스트 케이스 수 T (1 ≤ T ≤ 50)
- 각 테스트 케이스마다 괄호 문자열이 주어짐.

---

## 🔍 접근 방식

- **스택 자료구조**를 사용해 여는 괄호 '('를 담고, 닫는 괄호 ')'가 나오면 pop한다.
- 중간에 스택이 비었는데 ')'가 나오거나,
- 문자열을 다 확인했는데 스택에 '('가 남아 있으면 올바르지 않은 괄호 문자열.

- 최종 결과:
    - 올바른 경우 → `YES`
    - 올바르지 않은 경우 → `NO`

---

## 💡 배운 점 / 회고

- 스택을 활용한 괄호 짝 맞추기는 자료구조 기본 중 기본이다.
- 문자열을 순회하면서 바로바로 스택에 push/pop하면서 풀이하면 시간과 메모리를 아낄 수 있다.
- 한 번에 결과를 출력하기 위해 StringBuilder를 사용해 입출력 최적화를 고려했다.
- 실전 코딩테스트에서는 입력과 출력을 최대한 효율적으로 관리하는 것도 중요한 포인트다.

---

## 💻 Java 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char[] arr = sc.next().toCharArray();
            Stack<Character> st = new Stack<>();
            String result = "YES";
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == '(') {
                    st.push(arr[j]);
                } else {
                    if(st.isEmpty()) {
                        result = "NO";
                        break;
                    } else {
                        st.pop();
                    }
                }
            }
            if(!st.isEmpty()) result = "NO";
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
