package No43_boj_1012;

import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int m, n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            m = sc.nextInt(); // 배추밭 가로길이
            n = sc.nextInt(); // 배추밭 세로길이
            int k = sc.nextInt(); // 배추가 심어져있는 위치의 갯수

            map = new int[n][m];
            visited = new boolean[n][m];

            for(int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }

            int count = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if(map[y][x] == 1 && !visited[y][x]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    static void dfs(int x, int y) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue; // 범위 체크
            if(map[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(nx, ny);
            }

        }

    }

}
