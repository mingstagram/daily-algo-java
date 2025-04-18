package No23_boj_10814;

import java.util.*;

public class Main {
    static class Member {
        int age;
        String name;
        int index;

        Member(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new Member(age, name, i));
        }

        list.sort(Comparator.comparingInt((Member m) -> m.age)
                .thenComparingInt(m -> m.index));

        for (Member m : list) {
            System.out.println(m.age + " " + m.name);
        }
    }
}