package 부르트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로 {

    static int N;
    static int result = Integer.MIN_VALUE;
    static boolean[] visited;
    static int[] num = new int[N];
    static int[] selected = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
    }
    static void dfs(int count) {
        if(count == N) {

            int sum = 0;
            for(int i = 0; i < N - 1; i++) {
                sum += Math.abs(selected[i] + selected[i + 1]);
            }
            result = Math.max(sum, result);
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                selected[count] = num[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }
}
