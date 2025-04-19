package No25_boj_11655;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(Character.isLetter(arr[i])) {
                if(Character.isUpperCase(arr[i])) {
                    sb.append((char)((arr[i] - 'A' + 13) % 26 + 'A'));
                } else if(Character.isLowerCase(arr[i])) {
                    sb.append((char)((arr[i] - 'a' + 13) % 26 + 'a'));
                }
            } else {
                sb.append(arr[i]);
            }
        }
        System.out.println(sb.toString());

    }
}
