package _02_String;

/**
 * 11. 문자열 압축
 * 설명
 *
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 *
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 *
 * 단 반복횟수가 1인 경우 생략합니다.
 *
 *
 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출력
 * 첫 줄에 압축된 문자열을 출력한다.
 *
 *
 * 예시 입력 1
 *
 * KKHSSSSSSSE
 * 예시 출력 1
 *
 * K2HS7E
 * 예시 입력 2
 *
 * KSTTTSEEKFKKKDJJGG
 * 예시 출력 2
 *
 * KST3SE2KFK3DJ2G2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Practice11 {
    
    public String solution(String str) {
        String answer = "";
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(str.split("")));

        strList.add(" ");
        String prior = strList.get(0);
        int count = 0;
        for (String curr : strList) {
            if (!curr.equals(prior)) {
                if (count == 1) {
                    answer += prior;
                } else {
                    answer += prior + count;
                }
                count = 0;
            }
            count++;
            prior = curr;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Practice11 practice11 = new Practice11();
        System.out.println(practice11.solution(input));
    }
}
