package No32_boj_9012;

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
