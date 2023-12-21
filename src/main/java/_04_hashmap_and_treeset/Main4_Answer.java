package _04_hashmap_and_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 4. 모든 아나그램 찾기
 * 설명
 *
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 *
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 *
 * 입력
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 *
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 *
 *
 * 출력
 * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * bacaAacba
 * abc
 * 예시 출력 1
 *
 * 3
 * 힌트
 */

public class Main4_Answer {

    public int solution(String s, String t) {
        int answer = 0;

        Map<Character, Integer> sMap = new HashMap<>();
        int tSize = t.length();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ele : t.toCharArray()) {
            tMap.put(ele, tMap.getOrDefault(ele, 0) + 1);
        }

        // t의 사이즈를 윈도우 크기로 설정
        for (int rt = 0; rt < tSize - 1; rt++) {
            char sEle = s.charAt(rt);
            sMap.put(sEle, sMap.getOrDefault(sEle, 0) + 1);
        }

        // 윈도우 이동
        int lt = 0;
        for (int rt = tSize - 1; rt < s.length(); rt++) {
            char eleToAdd = s.charAt(rt);
            sMap.put(eleToAdd, sMap.getOrDefault(eleToAdd, 0) + 1);

            if (sMap.equals(tMap)) answer++;

            char eleToRemove = s.charAt(lt);
            sMap.put(eleToRemove, sMap.getOrDefault(eleToRemove, 0) - 1);
            if (sMap.get(eleToRemove) == 0) sMap.remove(eleToRemove);
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        Main4_Answer main = new Main4_Answer();
        System.out.println(main.solution(s, t));
    }
}
