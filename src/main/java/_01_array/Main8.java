package _01_array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 8. 등수구하기
 * 설명
 *
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 *
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 *
 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 *
 *
 * 입력
 * 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
 *
 *
 * 출력
 * 입력된 순서대로 등수를 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 5
 * 87 89 92 100 76
 * 예시 출력 1
 *
 * 4 3 2 1 5
 */

public class Main8 {

    public List<Integer> solution(List<Integer> scores) {
        List<Integer> scoresReversed = new ArrayList<>(scores);
        scoresReversed.sort(Comparator.reverseOrder());

        Map<Integer, Integer> ranks = new HashMap<>();
        int count = 1;
        for (Integer score : scoresReversed) {
            if (!ranks.containsKey(score)) {
                ranks.put(score, count);
            }
            count++;
        }
        List<Integer> answer = new ArrayList<>();
        scores.forEach(score -> answer.add(ranks.get(score)));

        return answer;
    }

    public List<Integer> solution_answer(List<Integer> scores) {
        List<Integer> answer = new ArrayList<>();
        int count;
        for (int i = 0; i < scores.size(); i++) {
            count = 1;
            for (int j = 0; j < scores.size(); j++) {
                if (scores.get(i) < scores.get(j)) {
                    count++;
                }
            }
            answer.add(count);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            scores.add(sc.nextInt());
        }

        Main8 main8 = new Main8();
        for (Integer answer : main8.solution_answer(scores)) {
            System.out.print(answer + " ");
        }
    }

}
