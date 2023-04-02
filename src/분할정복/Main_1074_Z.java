package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
    static int[][] map;
    static int r;
    static int c;
    public static int divide(int row, int col, int size) {

        if(size == 1) {
            return 0;
        }
        // 1번째 분할
        if(r < row + size / 2 && c < col + size / 2)
            return divide(row, col, size/2);

        // 2번째 분할
        else if(r < row + size / 2 && c < col + size)
            return divide(row, col + size / 2, size / 2) + (int) Math.pow(size / 2 , 2);

        // 3번째 분할
        else if(r < row + size && c < col + size / 2)
            return divide(row  + size / 2, col, size / 2) + (int) Math.pow(size / 2, 2) * 2;

        else
            return divide(row + size / 2, col + size / 2, size / 2) + (int) Math.pow(size / 2, 2) * 3;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2,N);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[size][size];

        System.out.println(divide(0,0, size));
    }
}
