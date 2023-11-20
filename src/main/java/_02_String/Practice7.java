package _02_String;

import java.util.Scanner;

/**
 * 7. 회문 문자열
 * 설명
 *
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 *
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 *
 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 *
 *
 * 입력
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 *
 * 출력
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * gooG
 * 예시 출력 1
 *
 * YES
 */

public class Practice7 {

    public String solution(String input) {
        String result = "";

        // 소문자로 바꾸기
        input = input.toLowerCase();

        // reverse 사용 비교
        StringBuilder original = new StringBuilder(input);
        StringBuilder reversed = new StringBuilder(input).reverse();
        if (original.toString().equals(reversed.toString())) {
            result = "YES";
        } else {
            result = "NO";
        }

        return result;
    }

    public String solution2(String input) {
        String result = "YES";

        input = input.toLowerCase();
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                result = "NO";
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Practice7 practice7 = new Practice7();
        System.out.println(practice7.solution2(input));
    }
}
