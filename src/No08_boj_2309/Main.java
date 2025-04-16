package No08_boj_2309;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrays = new int[9];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            arrays[i] = sc.nextInt();
        }

        loop:
        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                int temp = 0;
                list.clear();
                for(int k = 0; k < 9; k++) {
                    if(k != i && k != j) {
                        list.add(arrays[k]);
                        temp += arrays[k];
                    }
                }

                if(temp == 100) {
                    break loop;
                }

            }
        }

        Collections.sort(list);
        for(int item : list) {
            System.out.println(item);
        }

    }

}
