package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());

        boolean flag = true;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    flag = false;
                }
            }
        }

        if (flag) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

    }

    public static int bfs() {

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int x = now[1];
            int y = now[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 체크
                if(nx >= 0 || nx < N || ny >= 0 || ny < M) {
                    if(map[ny][nx] == 0) {
                        queue.add(new int[] {ny,nx});
                        map[ny][nx] = map[y][x] + 1;
                    }
                }
            }
            answer++;
        }

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) return -1;
                result = Math.max(result, map[i][j]);
            }
        }

        if(result == 1) return 0;
        else return result -1;
    }

}
