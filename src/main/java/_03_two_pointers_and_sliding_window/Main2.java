package _03_two_pointers_and_sliding_window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 2. 공통원소 구하기
 * 설명
 *
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 *
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 *
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 *
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 *
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 *
 *
 * 출력
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 *
 *
 * 예시 입력 1 
 *
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 * 예시 출력 1
 *
 * 2 3 5
 */

public class Main2 {
    
    public List<Integer> solution(List<Integer> a, List<Integer> b) {
        List<Integer> answer = new ArrayList<Integer>();

        Collections.sort(a);
        Collections.sort(b);

        int aPtr = 0, bPtr = 0;
        while (aPtr < a.size() && bPtr < b.size()) {
            if (a.get(aPtr) > b.get(bPtr)) {
                bPtr++;
            } else if (a.get(aPtr) < b.get(bPtr)) {
                aPtr++;
            } else {
                answer.add(a.get(aPtr));
                aPtr++;
                bPtr++;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aSize = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < aSize; i++) {
            a.add(sc.nextInt());
        }

        int bSize = sc.nextInt();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < bSize; i++) {
            b.add(sc.nextInt());
        }
        Main2 main = new Main2();
        for (Integer i : main.solution(a, b)) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
