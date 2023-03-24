package 부르트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
    static int T;
    static int minDiff;
    static int[][] food;
    static boolean[] visited;
    public static void combi(int at, int sourSum, int bitterSum) {
        if(at == T) {
            int count = 0;
            for(int i = 0; i < T; i++) {
                if(!visited[i]) count++;
            }
            if(count == T) return;
            minDiff = Math.min(minDiff, Math.abs(sourSum - bitterSum));
            return;
        }
        visited[at] = true;
        combi(at + 1, sourSum * food[at][0], bitterSum + food[at][1]);
        visited[at] = false;
        combi(at + 1, sourSum, bitterSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        T = Integer.parseInt(br.readLine());

        food = new int[T][2];
        minDiff = Integer.MAX_VALUE;
        visited = new boolean[T];

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
        }
        combi(0,1,0);
        System.out.println(minDiff);
    }

}
