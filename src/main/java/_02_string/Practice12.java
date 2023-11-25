package _02_string;

import java.util.Scanner;

public class Practice12 {
    public static String solution(int num, String code) {
        code = code.replace('#', '1').replace('*', '0');

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int parsed = Integer.parseInt(code.substring(i * 7, i * 7 + 7), 2);
            sb.append((char)parsed);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        String input1 = in.next();
        System.out.println(solution(num, input1));
        return ;
    }
}
