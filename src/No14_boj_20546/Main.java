package No14_boj_20546;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String password = sc.nextLine();
            if (password.equals("end")) break;

            boolean isAcceptable = true;
            boolean hasVowel = false;
            int vowelCount = 0;
            int consonantCount = 0;
            char prev = 0;

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);

                boolean isVowel = "aeiou".indexOf(c) != -1;

                // 모음 포함 여부
                if (isVowel) hasVowel = true;

                // 연속 모음/자음 체크
                if (isVowel) {
                    vowelCount++;
                    consonantCount = 0;
                } else {
                    consonantCount++;
                    vowelCount = 0;
                }

                if (vowelCount >= 3 || consonantCount >= 3) {
                    isAcceptable = false;
                    break;
                }

                // 같은 글자 연속 체크 (ee, oo는 예외)
                if (i > 0 && c == prev && c != 'e' && c != 'o') {
                    isAcceptable = false;
                    break;
                }

                prev = c;
            }

            if (!hasVowel) isAcceptable = false;

            if (isAcceptable) {
                System.out.println("<" + password + "> is acceptable.");
            } else {
                System.out.println("<" + password + "> is not acceptable.");
            }
        }
    }
}