package _03_two_pointers_and_sliding_window;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 5. 연속된 자연수의 합
 * 설명
 *
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 *
 * 만약 N=15이면
 *
 * 7+8=15
 *
 * 4+5+6=15
 *
 * 1+2+3+4+5=15
 *
 * 와 같이 총 3가지의 경우가 존재한다.
 *
 *
 * 입력
 * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 *
 *
 * 출력
 * 첫 줄에 총 경우수를 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 15
 * 예시 출력 1
 *
 * 3
 */

public class Main5 {

    public int solution(int n) {
        int answer = 0;

        List<Integer> numbers = new ArrayList<>();
        for (int number = 1; number < n; number++) {
            numbers.add(number);
        }

        int rt = 0, lt = 0;
        while (lt < n) {
            if (getSumOf(rt, lt, numbers) > n) {
                rt++;
            } else {
                if (getSumOf(rt, lt, numbers) == n) answer++;
                lt++;
            }
        }

        return answer;
    }

    public int getSumOf(int rt, int lt, List<Integer> numbers) {
        return numbers.subList(rt, lt).stream().mapToInt(i -> i).sum();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main5 main = new Main5();
        System.out.println(main.solution(n));
    }
}
