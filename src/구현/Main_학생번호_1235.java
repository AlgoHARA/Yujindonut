package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main_학생번호_1235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        int n = Integer.parseInt(br.readLine());

        String[] arraylist = new String[n];
        for (int i = 0; i < n; i++) {
            arraylist[i] = br.readLine();
        }
        HashSet<String> set = new HashSet<>();
        int length = arraylist[0].length();

        for (int len = 1; len <= length; len++) {
            for (int i = 0; i < n; i++) {
                set.add(arraylist[i].substring(length - len));
            }
            if (set.size() == n) {
                System.out.println(len);
                return;
            }
            set.clear();
        }
    }
}