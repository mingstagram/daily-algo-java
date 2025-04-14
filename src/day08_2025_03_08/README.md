# 📅 2025-03-08 - 단어 공부 (백준 1157)

- 문제 링크: [https://www.acmicpc.net/problem/1157](https://www.acmicpc.net/problem/1157)
- 난이도: 브론즈 1
- 알고리즘 분류: 문자열, 구현

---

## 📌 문제 요약

- 알파벳 대소문자로 이루어진 단어가 주어짐
- 대소문자 구분 없이 가장 많이 등장한 알파벳을 대문자로 출력
- 가장 많이 사용된 알파벳이 여러 개인 경우 `?` 출력

---

## 🔍 접근 방식

- 입력 문자열을 모두 대문자로 변환 (`toUpperCase()`)
- 알파벳 A~Z까지의 개수를 저장할 배열 선언 (`int[26]`)
- `char - 'A'`를 통해 인덱스를 계산하여 등장 횟수 기록
- 최댓값을 찾으며, 동점이면 `?`로 처리

---

## 💡 배운 점 / 회고

- `char - 'A'` 인덱싱은 자바에서 자주 사용하는 기법
- 문자열을 비교하거나 집계할 때는 **전처리(대문자화)**가 중요
- **최댓값 처리 시 조건 분기**(`== max`)를 명확히 구분하는 것이 핵심

---

## 💻 코드

```java 
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = -1;
        char result = '?';

        String word = sc.next().toUpperCase();
        int[] words = new int[26];
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            words[c - 'A']++;
        }

        for(int i = 0; i < 26; i++) {
            if(words[i] > max) {
                max = words[i];
                result = (char) (i + 'A');
            } else if(words[i] == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }

}
