package _08_Dfs_Bfs_Practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 5. 동전교환
 * 설명
 *
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 *
 * 각 단위의 동전은 무한정 쓸 수 있다.
 *
 *
 * 입력
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
 *
 * 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
 *
 *
 * 출력
 * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 3
 * 1 2 5
 * 15
 * 예시 출력 1
 *
 * 3
 * 힌트
 *
 * 출력 설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다.
 */
public class practice5 {
    static int N, M;
    static int answer = Integer.MAX_VALUE;

    public static void DFS(int l, int sum, Integer[] coin) {
        if (sum > M) {
            return;
        }
        if (l >= answer) {
            return;
        }
        if (sum == M) {
            answer = Math.min(l, answer);
        } else {
            for (int c : coin) {
                DFS(l + 1, sum + c, coin);
            }
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        N = in.nextInt();
        Integer[] coin = new Integer[N];
        for (int i = 0; i < N; i++) {
            coin[i] = in.nextInt();
        }
        Arrays.sort(coin, Collections.reverseOrder());
        M = in.nextInt();
        DFS(0, 0, coin);
        System.out.println(answer);
        return;
    }
}
