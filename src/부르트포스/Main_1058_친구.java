package 부르트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1058_친구 {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(line.charAt(j) == 'Y') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(k == i || k == j || i == j) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(map[i][j] <= 2) cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);

    }


}
