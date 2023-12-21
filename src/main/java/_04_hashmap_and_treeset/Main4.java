package _04_hashmap_and_treeset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

public class Main4 {

    public int solution(String s, String t) {
        int answer = 0;

        List<String> sList = new ArrayList<>();
        for (String ele : s.split("")) {
            sList.add(ele);
        }
        int tSize = t.length();
        Map<String, Integer> tMap = new HashMap<>();
        for (String ele : t.split("")) {
            tMap.put(ele, tMap.getOrDefault(ele, 0) + 1);
        }

        // t의 사이즈를 윈도우 크기로 설정
        Map<String, Integer> bucket = new HashMap<>();
        for (int rt = 0; rt < tSize - 1; rt++) {
            String sEle = sList.get(rt);
            bucket.put(sEle, bucket.getOrDefault(sEle, 0) + 1);
        }

        // 윈도우 이동
        int lt = 0;
        for (int rt = tSize - 1; rt < sList.size(); rt++) {
            String eleToAdd = sList.get(rt);
            bucket.put(eleToAdd, bucket.getOrDefault(eleToAdd, 0) + 1);

            if (checkBucketIsAnagramOfT(bucket, tMap)) answer++;

            String eleToRemove = sList.get(lt);
            bucket.put(eleToRemove, bucket.getOrDefault(eleToRemove, 0) - 1);
            if (bucket.get(eleToRemove) == 0) bucket.remove(eleToRemove);
            lt++;

        }

        return answer;
    }

    public boolean checkBucketIsAnagramOfT(Map<String, Integer> bucket, Map<String, Integer> tMap) {
        for (String tEle : tMap.keySet()) {
            if (!bucket.containsKey(tEle) && !tMap.get(tEle).equals(bucket.get(tEle))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        Main4 main = new Main4();
        System.out.println(main.solution(s, t));
    }
}
