package _06_sorting_and_searching;

/**
 * 2. 버블 정렬
 * 설명
 *
 * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 *
 * 정렬하는 방법은 버블정렬입니다.
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {

    public List<Integer> solution(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size() - i; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int tmp = numbers.get(j + 1);
                    numbers.set(j + 1, numbers.get(j));
                    numbers.set(j, tmp);
                }
            }
        }
        return numbers;
    }

    // 배열을 사용하는 솔루션
    public List<Integer> solution_answer(List<Integer> numbers) {
        int[] arr = numbers.stream().mapToInt(i -> i).toArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        Main2 main = new Main2();
        for (Integer i : main.solution_answer(numbers)) {
            System.out.print(i + " ");
        }

    }
}
