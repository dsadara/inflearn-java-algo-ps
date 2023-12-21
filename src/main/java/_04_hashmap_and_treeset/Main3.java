package _04_hashmap_and_treeset;

/**
 * 3. 매출액의 종류
 * 설명
 *
 * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
 *
 * 각 구간별로 구하라고 했습니다.
 *
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 *
 * 20 12 20 10 23 17 10
 *
 * 각 연속 4일간의 구간의 매출종류는
 *
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 *
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 *
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 *
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 *
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 *
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 *
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 *
 * 출력
 * 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 7 4
 * 20 12 20 10 23 17 10
 * 예시 출력 1
 *
 * 3 4 4 3
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public List<Integer> solution(int n, int k, List<Integer> sales) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> bucket = new HashMap<>();

        // 처음 k개 요소로 윈도우 초기화
        for (int rt = 0; rt < k - 1; rt++) {
            int sale = sales.get(rt);
            bucket.put(sale, bucket.getOrDefault(sale, 0) + 1);
        }

        // 슬라이딩 윈도우
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            // 오른쪽 추가
            int saleToAdd = sales.get(rt);
            bucket.put(saleToAdd, bucket.getOrDefault(saleToAdd, 0) + 1);

            // 구간 매출액 기록
            answer.add(bucket.size());

            // 왼쪽 제거
            int saleToRemove = sales.get(lt);
            bucket.put(saleToRemove, bucket.get(saleToRemove) - 1);
            if (bucket.get(saleToRemove) == 0) {
                bucket.remove(saleToRemove);
            }
            lt++;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> sales = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sales.add(sc.nextInt());
        }

        Main3 main = new Main3();
        for (Integer kinds : main.solution(n, k, sales)) {
            System.out.print(kinds + " ");
        }
    }
}
