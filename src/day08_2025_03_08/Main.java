package day08_2025_03_08;

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
