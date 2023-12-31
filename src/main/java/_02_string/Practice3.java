package _02_string;


import java.util.Scanner;

/**
 * 3. 문장 속 단어
 * 설명
 *
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 *
 * 문장속의 각 단어는 공백으로 구분됩니다.
 *
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
 *
 * 단어를 답으로 합니다.
 *
 * 예시 입력 1
 *
 * it is time to study
 *
 * 예시 출력 1
 *
 * study
 */
public class Practice3 {
    public static String solution(String input) {
        String[] words = input.split(" ");
        String result = "";
        for (String s : words) {
            if (result.length() < s.length()) {
                result = s;
            }
        }
        return result;
    }

    public static String solution2(String input) {
        int pos = 0;
        String result = "";

        while (input.indexOf(" ") != -1) {
            pos = input.indexOf(" ");
            String word = input.substring(0, pos);
            if (result.length() < word.length()) {
                result = word;
            }
            input = input.substring(pos+1);
        }

        if (result.length() < input.length()) {
            result = input;
        }

        return result;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        System.out.println(solution(input1));
        System.out.println(solution2(input1));
        return;
    }
}
