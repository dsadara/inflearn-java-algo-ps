package _06_sorting_and_searching;

import java.util.Scanner;

/**
 * 5. 중복 확인
 * 설명
 *
 * 현수네 반에는 N명의 학생들이 있습니다.
 *
 * 선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
 *
 * 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
 *
 * N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.
 *
 * 두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.
 *
 *
 * 출력
 * 첫 번째 줄에 D 또는 U를 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 8
 * 20 25 52 30 39 33 43 33
 * 예시 출력 1
 *
 * D
 */

public class Main5 {

    public String solution(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                } else if (arr[j] == arr[j+1]){
                    return "D";
                }
            }
        }
        return "U";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Main5 main = new Main5();
        System.out.print(main.solution(n, arr));
    }
}
