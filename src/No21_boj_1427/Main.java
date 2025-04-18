package No21_boj_1427;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        while (N > 0) {
            list.add(N % 10);
            N /= 10;
        }
        Collections.sort(list, Collections.reverseOrder());

        list.forEach(System.out::print);

    }
}
