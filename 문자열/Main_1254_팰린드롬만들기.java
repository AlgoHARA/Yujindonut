package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1254_팰린드롬만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        String s = br.readLine();
        int answer = s.length();

        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s.substring(i))) {
                break;
            }
            answer++;
        }

    }
    private static boolean isPalindrome(String s) {
        System.out.println(s);
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            if(s.charAt(start) != s.charAt(last)) return false;
            start++;
            last--;
        }
        return true;
    }

}
