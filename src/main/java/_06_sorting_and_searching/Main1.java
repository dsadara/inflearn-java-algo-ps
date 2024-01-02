package _06_sorting_and_searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1. 선택 정렬
 * 설명
 *
 * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 *
 * 정렬하는 방법은 선택정렬입니다.
 *
 *
 * 입력
 * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
 *
 * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
 *
 *
 * 출력
 * 오름차순으로 정렬된 수열을 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 6
 * 13 5 11 7 23 15
 * 예시 출력 1
 *
 * 5 7 11 13 15 23
 */

public class Main1 {

    public List<Integer> solution(int n, List<Integer> numbers) {
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i; j < n; j++) {
                if (numbers.get(idx) > numbers.get(j)) idx = j;
            }
            // swap
            int tmp = numbers.get(idx);
            numbers.set(idx, numbers.get(i));
            numbers.set(i, tmp);
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        Main1 main = new Main1();
        List<Integer> solution = main.solution(n, numbers);
        for (Integer number : solution) {
            System.out.print(number + " ");
        }
    }
}
