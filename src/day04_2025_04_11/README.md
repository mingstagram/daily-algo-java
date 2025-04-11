# 📅 2025-04-11 - 데크(Deque) (백준 10866)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/10866](https://www.acmicpc.net/problem/10866)
- 난이도: 실버 4
- 알고리즘 분류: 자료구조, 데크, 구현

---

## 📌 문제 요약

- 정수를 저장하는 데크(Deque)를 직접 구현하고 명령어를 처리하는 문제
- 처리할 명령어 종류:
    - `push_front X`: 정수 X를 덱의 앞에 넣는다.
    - `push_back X`: 정수 X를 덱의 뒤에 넣는다.
    - `pop_front`: 덱의 가장 앞에 있는 수를 빼고 출력. 비어있으면 -1
    - `pop_back`: 덱의 가장 뒤에 있는 수를 빼고 출력. 비어있으면 -1
    - `size`: 덱에 들어있는 정수의 개수 출력
    - `empty`: 덱이 비어있으면 1, 아니면 0 출력
    - `front`: 덱의 가장 앞 정수 출력. 비어있으면 -1
    - `back`: 덱의 가장 뒤 정수 출력. 비어있으면 -1

---

## 🔍 접근 방식

- `Deque<Integer>`(구현체는 `LinkedList`)를 사용하여 데크 연산 구현
- `offerFirst`, `offerLast`, `pollFirst`, `pollLast`, `peekFirst`, `peekLast` 등의 메서드를 통해 각 명령어 처리
- 추가적으로 `ArrayDeque`도 선언해보며 사용법을 비교해봄
- 출력은 `StringBuilder`를 사용하여 한 번에 출력

---

## 💡 배운 점 / 회고

- `Deque`는 양방향 삽입/삭제가 모두 필요한 상황에서 매우 유용한 자료구조
- `Deque` 인터페이스는 `LinkedList`, `ArrayDeque` 모두에서 구현 가능하며, 두 클래스의 사용법은 거의 동일함
- `LinkedList`는 범용성과 유연성, `ArrayDeque`는 성능 면에서 유리하다는 차이를 실습을 통해 이해함
- `ArrayDeque`는 내부적으로 배열 기반이기 때문에 인덱싱 성능이 좋고 메모리 효율도 좋음 (단, `null` 삽입은 불가)
- 실제 코드는 `LinkedList` 기반으로 작성했지만, `ArrayDeque`로도 쉽게 전환 가능
- 자료구조 문제를 풀며 다양한 구현체를 비교해보는 것도 좋은 공부가 됨

---

## 💻 코드

```java
package day04_2025_04_11;

import java.util.*;

public class Main {

    static Deque<Integer> deque = new LinkedList<>();
    static ArrayDeque<Integer> array_deque = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            switch (command) {
                case "push_front" :
                    push_front(sc.nextInt());
                    break;
                case "push_back" :
                    push_back(sc.nextInt());
                    break;
                case "pop_front" :
                    sb.append(pop_front()).append("\n");
                    break;
                case "pop_back" :
                    sb.append(pop_back()).append("\n");
                    break;
                case "size" :
                    sb.append(size()).append("\n");
                    break;
                case "empty" :
                    sb.append(empty()).append("\n");
                    break;
                case "front" :
                    sb.append(front()).append("\n");
                    break;
                case "back" :
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    static void push_front(int x) {
        deque.offerFirst(x);
    }

    static void push_back(int x) {
        deque.offerLast(x);
    }

    static int pop_front() {
        if(deque.isEmpty()) return -1;
        else return deque.pollFirst();
    }

    static int pop_back() {
        if(deque.isEmpty()) return -1;
        else return deque.pollLast();
    }

    static int size() {
        return deque.size();
    }

    static int empty() {
        return deque.isEmpty() ? 1 : 0;
    }

    static int front() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    static int back() {
        return deque.isEmpty() ? -1 : deque.peekLast();
    }
}
