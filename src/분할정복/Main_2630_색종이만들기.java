package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
    static int N;
    static int[][] map;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
    public static boolean checkColor(int row, int col, int size) {

        int color = map[row][col];
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(map[i][j] != color)  {
                    return false;
                }
            }
        }
        return true;
    }
    public static void divide(int row, int col, int n) {
        if(checkColor(row,col,n)) {
            if(map[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
        }

        int newSize = n / 2;
        divide(row, col, newSize);
        divide(row + newSize, col, newSize);
        divide(row, col + newSize, newSize);
        divide(row + newSize, col + newSize, newSize);
    }


}
