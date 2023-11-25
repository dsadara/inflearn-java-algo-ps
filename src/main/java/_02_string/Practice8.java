package _02_string;

import java.util.Scanner;

public class Practice8 {
    public static String solution(String input) {
        input = input.replaceAll("[^a-zA-Z]", "");
        StringBuilder sb = new StringBuilder(input.toLowerCase());
        String normal = sb.toString();
        sb.reverse();
        String reverse = sb.toString();
        if (normal.equals(reverse)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        System.out.println(solution(input1));
        return ;
    }
}
