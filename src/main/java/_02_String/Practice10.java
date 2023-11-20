package _02_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

public class Practice10 {
    public List<Integer> solution(String s, String t) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> indicesOfT = indexOfCinStr(s, t.charAt(0));
        List<String> sList = Arrays.asList(s.split(""));

        for (int i = 0; i < sList.size(); i++) {
            if (indicesOfT.contains(i)) {
                answer.add(0);
                continue;
            }
            answer.add(getCloseIndex(i, indicesOfT));
        }

        return answer;
    }

    public List<Integer> indexOfCinStr(String str, char c) {
        List<Integer> indices = new ArrayList<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == c) {
                indices.add(i);
            }
        }
        return indices;
    }

    public int getCloseIndex(int sIndex, List<Integer> indicesOfT) {
        int min = Integer.MAX_VALUE;
        for (Integer t : indicesOfT) {
            int dist = Math.abs(t - sIndex);
            min = Math.min(min, dist);
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();

        Practice10 practice10 = new Practice10();

        List<Integer> answer = practice10.solution(s, t);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i));
            if (i < answer.size() - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);

    }
}
