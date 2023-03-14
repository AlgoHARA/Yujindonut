package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_점프왕젤리_16173 {

    static int[][] map;
    static int[][] visited;
    static int n;

    public static boolean bfs() {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] next = q.poll();
            if (next[0] < 0 || next[1] < 0 || next[0] >= n || next[1] >= n) {
                continue;
            }
            if (visited[next[0]][next[1]] == 1) {
                continue;
            }
            if (next[0] == n - 1 && next[1] == n - 1) {
                return true;
            }
            int move = map[next[0]][next[1]];
            visited[next[0]][next[1]] = 1;
            q.add(new int[]{next[0] + move, next[1]});
            q.add(new int[]{next[0], next[1] + move});
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        if (bfs()) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }
}