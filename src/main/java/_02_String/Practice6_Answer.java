package _02_String;

/**
 * k 0 0
 * s 1 1
 * e 2 2
 * k 3 0
 * k 4 0
 * s 5 1
 * e 6 2
 * t 7 7
 * index와 indexof(input.charAt(index))가 다르면 중복임 이것을 이용
 */

import java.util.Scanner;

public class Practice6_Answer {
    public String solution(String input) {
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            if (i == input.indexOf(input.charAt(i))) {
                result += input.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Practice6_Answer practice6 = new Practice6_Answer();
        System.out.println(practice6.solution(input));
    }
}
