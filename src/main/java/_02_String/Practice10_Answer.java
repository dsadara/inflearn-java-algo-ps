package _02_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * 10. 가장 짧은 문자거리
 * 설명
 *
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 *
 * 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출력
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 *
 * 예시 입력 1
 *
 * teachermode e
 * 예시 출력 1
 *
 * 1 0 1 2 1 0 1 2 2 1 0
 */

public class Practice10_Answer {
    
    public List<Integer> solution(String s, String t) {
        List<Integer> answer = new ArrayList<>();
        List<String> sList = Arrays.asList(s.split(""));

        // right move
        int dist = 1000;
        for (String element : sList) {
            if (element.equals(t)) {
                dist = 0;
                answer.add(dist);
                continue;
            }
            dist++;
            answer.add(dist);
        }

        // left move
        int dist2  = 1000;
        for (int i = answer.size() - 1; i >= 0; i--) {
            String element = sList.get(i);
            if (element.equals(t)) {
                dist2 = 0;
                continue;
            }
            dist2++;
            answer.set(i, Math.min(answer.get(i), dist2));
        }

        return answer;
    }

    public static void main(String[] args) {
        Practice10_Answer main = new Practice10_Answer();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String c = sc.next();
        List<Integer> answer = main.solution(str, c);
        answer.forEach(number -> System.out.print(number + " "));
    }

}
