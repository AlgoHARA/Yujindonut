package 부르트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1100_하얀칸 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        int count = 0;
        for(int i = 0; i < 8; i++) {
            String[] a = br.readLine().split("");
            for(int j = 0; j < 8; j++) {
                if(i % 2 == 0 && j % 2 == 0 && a[j].equals("F")
                 || (i % 2 == 1 && j % 2 == 1 && a[j].equals("F"))) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
