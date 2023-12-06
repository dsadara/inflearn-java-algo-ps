package _01_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1. 큰 수 출력하기
 * 설명
 *
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 *
 * (첫 번째 수는 무조건 출력한다)
 *
 *
 * 입력
 * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 *
 *
 * 출력
 * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 6
 * 7 3 9 5 6 12
 * 예시 출력 1
 *
 * 7 9 6 12
 */

public class Main1 {

    public List<Integer> solution(List<Integer> inputs) {
        List<Integer> answer = new ArrayList<>();

        answer.add(inputs.get(0));
        int prior = inputs.get(0);
        for (Integer curr : inputs) {
            if (curr > prior) {
                answer.add(curr);
            }
            prior = curr;
        }

        return answer;
    }

    public List<Integer> solution2(List<Integer> inputs) {
        List<Integer> answer = new ArrayList<>();
        answer.add(inputs.get(0));
        for (int i = 1; i < inputs.size(); i++) {
            if (inputs.get(i - 1) < inputs.get(i)) {
                answer.add(inputs.get(i));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();

        List<Integer> inputs = new ArrayList<>();
        for (int i = 0; i < input1; i++) {
            inputs.add(in.nextInt());
        }

        Main1 main1 = new Main1();
        List<Integer> answer = main1.solution2(inputs);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }
}
